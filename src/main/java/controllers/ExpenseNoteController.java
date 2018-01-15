/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.validation.Valid;
import model.Currency;
import model.Expense;
import model.ExpenseLine;
import model.ExpenseType;
import model.Rate;
import model.User;
import model.UserRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repositories.ExpenseLineRepository;
import repositories.ExpenseRepository;
import repositories.ExpenseTypeRepository;
import repositories.UserRepository;
import repositories.UserRolesRepository;

/**
 *
 * @author AIK
 */
@Controller
@EnableAutoConfiguration
@EntityScan("model")
@EnableJpaRepositories("repositories")
public class ExpenseNoteController {

    // Variables List Declaration  
    @Autowired
    ExpenseTypeRepository expenseTypeRepository;
    @Autowired
    ExpenseLineRepository expenseLineRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    UserRolesRepository userRolesRepository;

    // Variables List 
    protected final Log logger = LogFactory.getLog(getClass());
    private List<ExpenseLine> expenseLineList;
    private List<ExpenseType> expenseTypeList;
    private List<Expense> expenses;
    private List<Expense> expensesListApproved;
    private List<Expense> currentUserExpensesList;
    private List<Expense> selectedUserExpensesList;
    private User user;
    private List<User> users;
    private double totalAmountExpenses = 0;
    private long lastExpenseId = 0;
    private boolean bool = false;
    private boolean bool2 = false;
    private String status[] = {"Yes", "No"};
    private boolean printPage = false;
    private Expense theSelectedOne;
    private List<Expense> list;
    private List<ExpenseType> list1;
    private List<UserRole> userRoleList;

    /* This method shows the current user connected to the app */
    @ModelAttribute("user")
    public User currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            user = userRepository.findByUserName(currentUserName);
        }
        return user;
    }

    /* Return the userRoleList */
    @ModelAttribute("userRoleList")
    List<UserRole> findAllUserRole() {
        userRoleList = (List<UserRole>) userRolesRepository.findAll();
        return userRoleList;
    }


    /*@ModelAttribute("rates")
    public Rate[] showRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Rate[]> responseEntity = restTemplate.getForEntity("https://bitpay.com/api/rates", Rate[].class);
        Rate[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        return objects;
    }*/
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /* Call the Currency API and return the currency object */
    @ModelAttribute("currency")
    public Currency getCurrency() throws MalformedURLException, IOException, JSONException {

        URL seatURL = new URL("http://api.fixer.io/latest?base=DKK");

        BufferedReader br = new BufferedReader(new InputStreamReader(seatURL.openStream(), Charset.forName("UTF-8")));
        String readAPIResponse = " ";
        StringBuilder jsonString = new StringBuilder();

        while ((readAPIResponse = br.readLine()) != null) {
            jsonString.append(readAPIResponse);
        }
        Currency c = new Currency();

        JSONObject obj = new JSONObject(jsonString.toString());
        c.setBase(obj.get("base").toString());
        c.setDate(obj.get("date").toString());

        JSONObject rates = obj.getJSONObject("rates");
        Iterator<String> keys = rates.keys();
        while (keys.hasNext()) {
            String name = keys.next();
            c.getRates().add(new Rate(name, rates.getDouble(name)));
        }
        return c;
    }

    /* Method allow to convert an amount a the partular date choosen into another currencyBase value */
    public double getRateValue(String date, String currencyBase, String otherCurrency) throws MalformedURLException, IOException, JSONException {
        //      call the API to convert the amount in Euro
        URL seatURL = new URL("http://api.fixer.io/" + date.replace('/', '-') + "?base=" + currencyBase);
        BufferedReader br = new BufferedReader(new InputStreamReader(seatURL.openStream(), Charset.forName("UTF-8")));
        String readAPIResponse = " ";
        StringBuilder jsonString = new StringBuilder();
        while ((readAPIResponse = br.readLine()) != null) {
            jsonString.append(readAPIResponse);
        }

        Currency c = new Currency();

        JSONObject obj = new JSONObject(jsonString.toString());
        c.setBase(obj.get("base").toString());
        c.setDate(obj.get("date").toString());

        JSONObject rates = obj.getJSONObject("rates");
        Iterator<String> keys = rates.keys();
        while (keys.hasNext()) {
            String name = keys.next();
            c.getRates().add(new Rate(name, rates.getDouble(name)));
        }
        double euroRateValue = 0;
        boolean test = false;
        for (Rate rate : c.getRates()) {
            if (rate.getName().equals(otherCurrency)) {
                test = true;
                euroRateValue = rate.getValue();
            }
        }
        return euroRateValue;
    }

    /* Creation of a new ExpenseType */
    @ModelAttribute("expenseType")
    public ExpenseType newExpenseType() {
        return new ExpenseType();
    }

    /* Return the expenseList */
    @ModelAttribute("expenseTypeList")
    List<ExpenseType> findAllExpenseType() {
        expenseTypeList = (List<ExpenseType>) expenseTypeRepository.findAll();
        return expenseTypeList;
    }

    /* Creation of a new ExpenseType */
    @ModelAttribute("expenseline")
    public ExpenseLine newExpenseLine() {
        return new ExpenseLine();
    }

    /* Creation of a new Expense */
    @ModelAttribute("expense")
    public Expense newExpense() {
        return new Expense();
    }

    /* Return the expenseList of all users */
    @ModelAttribute("expenseList")
    List<Expense> findAllExpense() {
        expenses = (List<Expense>) expenseRepository.findAll();
        return expenses;
    }

    /* Return the approved expenseList of all users */
    @ModelAttribute("approvedExpenseList")
    List<Expense> findAllApprovedExpense() {
        expensesListApproved = (List<Expense>) expenseRepository.findByApprovalStatus(status[0]);
        return expenses;
    }


    /* Return all the users of the Application */
    @ModelAttribute("users")
    List<User> findAllUsers() {
        users = (List<User>) userRepository.findAll();
        return users;
    }

    @ModelAttribute("currentStatus")
    public String[] getStatus() {
        return status;
    }

    /* Return a form to Add a new Expense */
    @GetMapping("/addExpenseline")
    public String addExpenselineForm(Model mdl, Model mdl1) throws ParseException {
        if (bool2 == true) {
            totalAmountExpenses = 0; // reinitializee the amount of the list :)    
            Expense theLastExpense = expenses.get(expenses.size() - 1);
            expenseLineList = (List<ExpenseLine>) expenseLineRepository.findAll();
            for (int i = 0; i < expenseLineList.size(); i++) {
                if (theLastExpense.equals(expenseLineList.get(i).getExpense())) {
                    mdl1.addAttribute("expenseLineList", theLastExpense.getExpenseLineList());
                    break; // get out of the loop asap you find the first occurence of theLastExpense
                }
            }

            for (int i = 0; i < theLastExpense.getExpenseLineList().size(); i++) {
                totalAmountExpenses = totalAmountExpenses + theLastExpense.getExpenseLineList().get(i).getAmount();
            }

            NumberFormat format = NumberFormat.getInstance();
            format.setMinimumFractionDigits(2);
            String s = format.format(totalAmountExpenses);
            if (totalAmountExpenses != 0) {
                totalAmountExpenses = ((double) format.parse(s));
            }
//            totalAmountExpenses = theLastExpense.getTotal();
        }
        mdl.addAttribute("totalAmountExpense", totalAmountExpenses);
        return "addExpenseLineForm";
    }

    @PostMapping("/addExpenseline")
    public String saveExpenseLine(@Valid @ModelAttribute("expenseline") ExpenseLine expenseLine, BindingResult result) throws MalformedURLException, IOException, JSONException, ParseException {
        /*
    BindingResult interface allows to apply a Valid annotation and to bind result to view
         */
        if (result.hasErrors()) {
            System.out.println("There was an error" + result);
            return "addExpenseLineForm";
        }
//        String day = date.substring(0, 2);
//        String month = date.substring(3, 5);
//        
//        logger.info(date);
//        String year = date.substring(6, date.length());
//        date = year +"/"+month+"/"+day;

//        Creation of a new Expense
        Expense expense = new Expense();
        if (bool == false) {
            expense.setApprovalDate(new Date());
            expense.setApprovalStatus(status[1]);
            expense.setSubmissionDate(new Date());
//        expense.setTotal();
            expense.setSubmitter(user);
//            expense.setApprover(user); the Approver is not knonw for the moment
            expenseRepository.save(expense);
            expenses = (List<Expense>) expenseRepository.findAll();
        }
        bool = true; // set the boolean at true to avoid the creation of a new expense in current session 
//        End of the Expense  

        String date = expenseLine.getDate().substring(0, 10);
        Double amount = expenseLine.getAmount();
        String currencyBase = expenseLine.getCurrency();
        String otherCurrency = "EUR";

        double euroRateValue = getRateValue(date, currencyBase, otherCurrency);
        expenseLine.setDate(date);
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        String s = format.format(amount * euroRateValue);

        System.out.println(expenses.size());
        expenseLine.setAmount((double) format.parse(s));
        expenseLine.setExpense(expenses.get(expenses.size() - 1));
        System.out.println((double) format.parse(s));
        expenseLineRepository.save(expenseLine);

//        logger.info(day);
//        logger.info(month);
//        logger.info(year);
//        logger.info(date);
        System.out.println("The Expenseline has been added successfuly");
        bool2 = true; // set the boolean at true to allow the showing of theLastExpense list of expenseLines
        return "redirect:/addExpenseline";

    }

    /* Delete a selected expenseline in the list */
    @GetMapping("/expenseline/delete/{id}")
    public String deleteExpenseLine(@PathVariable Long id) {
        expenseLineRepository.delete(id);
        return "redirect:/addExpenseline";
    }

    /* Modify the selected expenseline in the list */
    @GetMapping("expenseline/modify/{id}")
    public String modifyExpenseLine(@PathVariable long id, Model model) throws IOException, MalformedURLException, JSONException {
        ExpenseLine theSelected = expenseLineRepository.findOne(id);
        model.addAttribute("expenseline", theSelected);
        return "addExpenseLineForm";
    }

    @PostMapping("expenseline/modify/{id}")
    public String modifyExpenseLine(@ModelAttribute("expenseline") @Valid ExpenseLine expenseLine, BindingResult result) {
        /*
        BindingResult interface allow to apply a validator and to bind results to the vue 
         */
        if (result.hasErrors()) { // Verify if the field has an input error
            return "addExpenseLineForm";
        } // i have to do some staff here 
        return "redirect:/addExpenseLineForm";
    }

    /* show the list of all the current user Expenses */
    @GetMapping("/expenseList")
    public String showExpenseList(Model mld) {
        currentUserExpensesList = (List<Expense>) expenseRepository.findBySubmitter(user);
        mld.addAttribute("currentUserExpenseList", currentUserExpensesList);
        return "expenseList";
    }

    /* Method to save the expenseLine into the expense and calculate the total of amount when pushing on the submit button */
    @GetMapping("/submission")
    public String saveExpenseNote() throws ParseException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, MessagingException {

        double total = 0;
        Expense theLastExpense = expenses.get(expenses.size() - 1); // Direct access to the last expense of the list 
        for (int i = 0; i < expenseLineList.size(); i++) {
            if (theLastExpense.equals(expenseLineList.get(i).getExpense())) {
                NumberFormat format = NumberFormat.getInstance();
                format.setMinimumFractionDigits(2);
                String s = format.format(expenseLineList.get(i).getAmount());
                total = total + (double) format.parse(s);
                expenses.get(expenses.size() - 1).setTotal(total);
                expenseRepository.save(expenses.get(expenses.size() - 1)); // update theLastExpense after having calculate his total amount

                // alert the app admin that an new expense has been added by user
//                smtpMailSender.send("expensesnote@gmail.com", "Expense Notes", "<p>The person with Username <b>" + user.getUserName() + "</b>,</p>" + "<p>just added an new Expense.</p>");
            }
        }
        totalAmountExpenses = 0;
        bool = false; // this variable is set to false in other to allow the creation of a new expense in the current session
        bool2 = false; // set the boolean at false to avoid loading of theLastExpense list of expenseLines when getting the index page
        return "index";
    }

    /* Show the detail list of the selected expense */
    @GetMapping("view/expense/detail/{id}")
    public String detailExpense(@PathVariable Long id, Model mld) {
        for (Expense expense : expenses) {
            if (id == expense.getId()) {
                mld.addAttribute("expenseDetails", expense.getExpenseLineList());
                mld.addAttribute("totalOfSelectedExpense", expense.getTotal());
                mld.addAttribute("printPage", expense.getApprovalStatus()); // this line is set to verify the right approvalStatus of the expense(if Yes the print else don't show the print button)
            }
        }
        return "detailsExpense";
    }

    /* Delete a selected expenseline in the list */
    @GetMapping("/expense/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        Expense expense = expenseRepository.findOne(id);
        expenseLineList = (List<ExpenseLine>) expenseLineRepository.findAll();
        int i = 0;
        while (i < expenseLineList.size()) {
            if (expense.equals(expenseLineList.get(i).getExpense())) {
//                expenseLineList.remove(expenseLineList.get(i));
                expenseLineRepository.delete(expenseLineList.get(i));
            }
            i++;
        }
        expenseRepository.delete(id);
        return "redirect:/expenseList";
    }

    /* This methods shows the most used Currency of the current user */
    @GetMapping("/theMostUsedCurrency")
    public String mostUsedCurrency(Model mld) {
        currentUserExpensesList = (List<Expense>) expenseRepository.findBySubmitter(user);
        List<String> currencyList = new ArrayList<>();
        for (Expense expense : currentUserExpensesList) {
            for (ExpenseLine expenseLine : expense.getExpenseLineList()) {
                currencyList.add(expenseLine.getCurrency());
            }
        }

        Set<String> unique = new HashSet<String>(currencyList);
        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (String key : unique) {
//            System.out.println(key + ": " + Collections.frequency(currencyList, key));
            intList.add(Collections.frequency(currencyList, key));
            stringList.add(key);
            mld.addAttribute("frequency", intList);
        }
        mld.addAttribute("key", stringList);
        return "bestCurrency";
    }

    /* This methods shows the most used ExpenseType of the current user */
    @GetMapping("/theMostUsedExpenseType")
    public String mostUsedExpenseType(Model mld) {
        currentUserExpensesList = (List<Expense>) expenseRepository.findBySubmitter(user);
        List<String> expenseTypeList = new ArrayList<>();
        for (Expense expense : currentUserExpensesList) {
            for (ExpenseLine expenseLine : expense.getExpenseLineList()) {
                expenseTypeList.add(expenseLine.getExpenseType().getName().toString());
            }
        }

        Set<String> unique = new HashSet<String>(expenseTypeList);
        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (String key : unique) {
//            System.out.println(key + ": " + Collections.frequency(currencyList, key));
            intList.add(Collections.frequency(expenseTypeList, key));
            stringList.add(key);
            mld.addAttribute("frequency", intList);
        }
        mld.addAttribute("key", stringList);
        return "theMostUsedExpenseType";
    }

    /* All the users Methods are above :) */
//    ---------------------------------------------
    /* All the Manager Methods are Below :) */

 /* Return the list of all the users if the Application and get all the unapproved expense of each of them*/
    @GetMapping("/usersList")
    public String usersList(Model mld) {
        List<Integer> intList = new ArrayList<>();
        for (User user1 : users) {
            list = expenseRepository.findByApprovalStatusAndSubmitter(status[1], user1);
            int n = list.size();
            intList.add(n);
        }
        mld.addAttribute("list", intList);
        return "usersListManager";
    }

    @GetMapping("/managerList")
    public String managerList(Model mld) {
        List<User> managerList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (UserRole role : userRoleList) {
            if (role.getRole().equals("ROLE_MANAGER")) {
                managerList.add(userRepository.findByUserId(role.getUserid()));
            }
        }

        List<Expense> nonApprovedExpenseList = new ArrayList<>();
        for (User user1 : managerList) {
            nonApprovedExpenseList = expenseRepository.findByApprovalStatusAndSubmitter(status[1], user1);
            int n = nonApprovedExpenseList.size();
            intList.add(n);
        }
        mld.addAttribute("managerList", managerList);
        mld.addAttribute("list", intList);
        return "managerListAdmin";
    }

    /* Show the expenses list of the selected User */
    @GetMapping("manager/users/expenseList/detail/{id}")
    public String selectedExpenseList(@PathVariable Long id, Model mld) {
        if (expenses.isEmpty()) {
            mld.addAttribute("selectedUser", userRepository.findOne(id));
        }
        for (Expense expense : expenses) {
            if (id == expense.getSubmitter().getUserId()) {
                selectedUserExpensesList = (List<Expense>) expenseRepository.findBySubmitter(expense.getSubmitter());
                mld.addAttribute("userExpensesList", selectedUserExpensesList);
            }
        }

        return "userExpensesListManager";
    }

    /* Show the detail list of the selected expense */
    @GetMapping("/manager/users/expenseList/detail/view/expense/detail/{id}")
    public String detailExpenseManager(@PathVariable Long id, Model mld) {
        for (Expense expense : expenses) {
            if (id == expense.getId()) {
                mld.addAttribute("expenseDetails", expense.getExpenseLineList());
                mld.addAttribute("totalOfSelectedExpense", expense.getTotal());
                mld.addAttribute("printPage", expense.getApprovalStatus());
            }
        }
        return "detailsExpense";
    }

    /* Delete a selected expense in the list of the selected User */
    @GetMapping("/manager/users/expenseList/detail/manager/users/expense/delete/{id}")
    public String deleteExpenseManager(@PathVariable Long id) {
        Expense expense = expenseRepository.findOne(id);
        expenseLineList = (List<ExpenseLine>) expenseLineRepository.findAll();
        int i = 0;
        while (i < expenseLineList.size()) {
            if (expense.equals(expenseLineList.get(i).getExpense())) {
//                expenseLineList.remove(expenseLineList.get(i));
                expenseLineRepository.delete(expenseLineList.get(i));
            }
            i++;
        }
        expenseRepository.delete(id);
        return "redirect:/usersList";
    }


    /* Validate an Expense Note by changing its status */
    @GetMapping("/manager/users/expenseList/detail/manager/users/expense/modify/{id}")
    public String changeExpenseStatus(@PathVariable long id, Model model) {
        theSelectedOne = expenseRepository.findOne(id);
        model.addAttribute("expense", theSelectedOne);
        return "changeStatus";
    }

    @PostMapping("/manager/users/expenseList/detail/manager/users/expense/modify/{id}")
    public String changeExpenseStatus(@RequestParam("theStatus") String value, @Valid Expense expense, BindingResult result) throws com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, MessagingException {
        theSelectedOne.setApprovalStatus(status[0]);
        theSelectedOne.setApprover(user);
        theSelectedOne.setApprovalDate(new Date());

        // alert the user that his expense has been approved by his manager
//        smtpMailSender.send(theSelectedOne.getSubmitter().getEmail(), "Expense Notes", "<p>Hello <b>" + theSelectedOne.getSubmitter().getUserName() + "</b>, </p>" + "<p>your expense has been approved.</p>");
        expenseRepository.save(theSelectedOne);
        // Return on the right page depending of the userrole
        UserRole role = userRolesRepository.findRoleByuserid(user.getUserId());
        if (role.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/usersList";
        } else {
            return "redirect:/managerList";
        }
//        return "redirect:/usersList";
    }

    /* Get the number of expense submitted by each user */
    @GetMapping("/manager/statistics/bestSubmitter")
    public String getBestSubmitter(Model mld) {
        List<Integer> intList = new ArrayList<>();
        for (User user1 : users) {
            list = expenseRepository.findByApprovalStatusAndSubmitter(status[0], user1);
            int n = list.size();
            intList.add(n);
        }
        mld.addAttribute("list", intList);
        return "bestSubmitter";
    }

    /* Shows the highest expense by user */
    @GetMapping("/highestExpenseByUsers")
    public String statisticsHighestExpense() {
        return "highestSubmitter";
    }

    /* Show the expenses list of the selected User */
    @GetMapping("manager/users/statistics/expenseList/detail/{id}")
    public String StatiticsSelectedExpenseList(@PathVariable Long id, Model mld) {
        if (expenses.isEmpty()) {
            mld.addAttribute("selectedUser", userRepository.findOne(id));
        }
        for (Expense expense : expenses) {
            if (id == expense.getSubmitter().getUserId()) {
                selectedUserExpensesList = (List<Expense>) expenseRepository.findByApprovalStatusAndSubmitter(status[0], expense.getSubmitter());
                mld.addAttribute("userExpensesList", selectedUserExpensesList);
            }
        }
        return "statisticsUserExpenseList";
    }

    /* The most used expenseType */
    @GetMapping("/bestExpenseType")
    public String bestExpenseType(Model mld) {
        List<Integer> intList = new ArrayList<>();
        for (ExpenseType expenseType : expenseTypeList) {
            expenseLineList = expenseLineRepository.findByExpenseType(expenseType);
            int nb = expenseLineList.size();
            intList.add(nb);
        }
        mld.addAttribute("list", intList);
        return "bestExpenseType";
    }

    /* The highest expense of the application */
    @GetMapping("/bestExpense")
    public String bestExpense() {
        return "bestExpense";
    }

//    @GetMapping("/chart.htm")
//    public String doGet(Model mld) throws JsonProcessingException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        //Set pretty printing of json
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        //1. Convert List of Person objects to JSON
////        List<User> intList = new ArrayList<>();
////        intList = (List<Expense>) expenseRepository.findAll();
//        String arrayToJson = objectMapper.writeValueAsString(expenses);
//        System.out.println("1. Convert List of person objects to JSON :");
//        System.out.println(arrayToJson);
//        mld.addAttribute("list", arrayToJson);
//        return "test";
//    }
    /////////////////////// Send an email /////////////////////////////
    @GetMapping("/send-mail")
    public void sendMail() throws MessagingException {

        try {
            smtpMailSender.send("kodjane09@hotmail.com", "Expense Notes", "First Mail from Expense Notes");
        } catch (com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException ex) {
            Logger.getLogger(ExpenseNoteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
