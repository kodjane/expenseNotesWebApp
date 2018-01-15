/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.User;
import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.UserRepository;
import repositories.UserRolesRepository;

/**
 *
 * @author Kodjane Aime Dieudonne
 */
@Controller
@EnableAutoConfiguration
@EntityScan("model")
@EnableJpaRepositories("repositories")

public class LoginController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRolesRepository userRolesRepository;
    @Autowired
    private SmtpMailSender smtpMailSender;

    @ModelAttribute("user")
    public User newUser() {
        return new User();
    }

    @GetMapping("/login")
    public String login() {
        return ("login");
    }

    @PostMapping("/login")
    public String loginTest() {
        return ("index");
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; // il est preferable de rediriger vers un formulaire de logout
    }

    @GetMapping("/inscription")
    public String inscription() {
        return ("inscriptionForm");
    }

    @PostMapping("/inscription")
    public String inscriptionUser(@ModelAttribute("user") @Valid User user, BindingResult result) throws MessagingException, javax.mail.MessagingException {
        /*
    BindingResult interface qui permet d'appliquer un validateur et de lier les résultats avec les vues
         */
        if (result.hasErrors()) {
            return "inscriptionForm";
        }

        user.setEnabled(1);
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);

        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getUserId());
        userRole.setRole("ROLE_USER");
        userRolesRepository.save(userRole);
        
//        send email to inform the administrator about the news registrations
//        smtpMailSender.send("expensesnote@gmail.com", "Expense Notes", "<p>The person with Username <b>" + user.getUserName() + "</b>,</p>" + "<p>just registred in Expense Notes App.</p>");
//        send email to thank registred user 
//        smtpMailSender.send(user.getEmail(), "Expense Notes", "<p>Hello <b>" + user.getUserName()+ "</b>, </p>" + "<p>thank for registreing with us.</p>");
        return "index";
    }

}
