/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expense;
import model.ExpenseLine;
import model.ExpenseType;
import model.User;
import org.codehaus.jettison.json.JSONArray;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import repositories.ExpenseLineRepository;
import repositories.ExpenseRepository;
import repositories.ExpenseTypeRepository;
import repositories.UserRepository;

/**
 *
 * @author AIK
 */
@Controller
@EnableAutoConfiguration
@EntityScan("model")
@EnableJpaRepositories("repositories")
@RequestMapping("/chart.htm")
public class ChartController {

    // Variables List Declaration  
    @Autowired
    ExpenseTypeRepository expenseTypeRepository;
    @Autowired
    ExpenseLineRepository expenseLineRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    UserRepository userRepository;

    private List<Expense> expenses;
    private List<User> users;
    private List<Expense> expensesListApproved;
    private List<Expense> list;
    private List<ExpenseType> expenseTypeList;
    private List<ExpenseLine> expenseLineList;
    private List<Expense> currentUserExpensesList;
    private User user;

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
    
    /* Return the expenseList of all users */
    @ModelAttribute("expenseList")
    List<Expense> findAllExpense() {
        expenses = (List<Expense>) expenseRepository.findAll();
        return expenses;
    }
    
    /* Return the expenseList */
    @ModelAttribute("expenseTypeList")
    List<ExpenseType> findAllExpenseType() {
        expenseTypeList = (List<ExpenseType>) expenseTypeRepository.findAll();
        return expenseTypeList;
    }

    /* Return the approved expenseList of all users */
    @ModelAttribute("approvedExpenseList")
    List<Expense> findAllApprovedExpense() {
        expensesListApproved = (List<Expense>) expenseRepository.findByApprovalStatus("Yes");
        return expenses;
    }

    /* Return all the users of the Application */
    @ModelAttribute("users")
    List<User> findAllUsers() {
        users = (List<User>) userRepository.findAll();
        return users;
    }

    @RequestMapping("/bestExpenseGraph")
    public String bestExpenseGraph() {
        return "bestExpenseGraph";
    }
    
    @RequestMapping("/bestSubmitterGraph")
    public String bestSubmitterGraph() {
        return "bestSubmitterGraph";
    }
    
    @RequestMapping("/bestExpenseTypeGraph")
    public String bestExpenseTypeGraph() {
        return "bestExpenseTypeGraph";
    }
    
    @RequestMapping("/bestExpenseTypeCurrentUserGraph")
    public String bestExpenseTypeCurrentUserGraph() {
        return "bestExpenseTypeCurrentUserGraph";
    }
    
    @RequestMapping("/bestCurrencyCurrentUserGraph")
    public String bestCurrencyCurrentUserGraph() {
        return "bestCurrencyCurrentUserGraph";
    }

    @RequestMapping(value = "dataExpenseListApproved.htm", method = RequestMethod.GET)
    public @ResponseBody String dataExpense() throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //1. Convert List of Person objects to JSON
//        List<User> intList = new ArrayList<>();
//        intList = (List<Expense>) expenseRepository.findAll();
        String arrayToJson = objectMapper.writeValueAsString(users);
        System.out.println("1. Convert List of person objects to JSON :");
        System.out.println(arrayToJson);

        String arrayToJson2 = objectMapper.writeValueAsString(expensesListApproved);
        System.out.println("1. Convert List of expense objects to JSON :");
        System.out.println(arrayToJson2);
        return arrayToJson2;
    }

    @RequestMapping(value = "bestSubmitter.htm", method = RequestMethod.GET)
    public @ResponseBody String dataSubmitter() throws JsonProcessingException, IOException, JSONException {
        List<Integer> intList = new ArrayList<>();
        for (User user1 : users) {
            list = expenseRepository.findByApprovalStatusAndSubmitter("Yes", user1);
            int n = list.size();
            intList.add(n);
        }
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<users.size();i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("userName", users.get(i).getUserName());
            formDetailsJson.put("Occurence",intList.get(i));
            jsonArray.put(formDetailsJson);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
    
    @RequestMapping(value = "bestExpenseType.htm", method = RequestMethod.GET)
    public @ResponseBody String dataExpenseType() throws JsonProcessingException, IOException, JSONException {
        List<Integer> intList = new ArrayList<>();
        for (ExpenseType expenseType : expenseTypeList) {
            expenseLineList = expenseLineRepository.findByExpenseType(expenseType);
            int nb = expenseLineList.size();
            intList.add(nb);
        }
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<expenseTypeList.size();i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("name", expenseTypeList.get(i).getName());
            formDetailsJson.put("Occurence",intList.get(i));
            jsonArray.put(formDetailsJson);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
    
    /* This methods shows the most used ExpenseType of the current user */
    @RequestMapping(value = "bestExpenseTypeCurrentUser.htm", method = RequestMethod.GET)
    public @ResponseBody String dataExpenseTypeCurrentUser() throws JsonProcessingException, IOException, JSONException {
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
        }
        
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<stringList.size();i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("name", stringList.get(i));
            formDetailsJson.put("Occurence",intList.get(i));
            jsonArray.put(formDetailsJson);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
    
    /* This methods shows the most used Currency of the current user */
    @RequestMapping(value = "bestCurrencyCurrentUser.htm", method = RequestMethod.GET)
    public @ResponseBody String dataCurrencyCurrentUser() throws JsonProcessingException, IOException, JSONException {
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
        }
        
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<stringList.size();i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("Currency", stringList.get(i));
            formDetailsJson.put("Occurence",intList.get(i));
            jsonArray.put(formDetailsJson);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
}
