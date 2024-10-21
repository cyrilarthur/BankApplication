package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Model.Customer;
import com.example.demo.Services.BankServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankServiceController {
    @Autowired // Injects an instance of BankService, enabling dependency injection
    private BankServices bankServices;

    // Home page
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register") // Maps HTTP GET requests for the "/register" URL to this method
    @Transactional
    public  String registrationForm(Model model) {
        // Adds a new Customer object to the model to be used in the registration form
        model.addAttribute("customer", new Customer());
        // Returns the name of the view (template) to be rendered, in this case "register"
        return "register";
    }

    @PostMapping("/register") // Maps HTTP POST requests for the "/register" URL to this method
    @Transactional
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        // Calls the bankService to register a new customer using the customer's name and email
        Customer savedCustomer = bankServices.registerCustomer(customer.getName(),customer.getEmail());
        System.out.println("Registering customer: " + customer.getName() + ", " + customer.getEmail());
        // Adds the saved customer object to the model to be accessed in the view
        model.addAttribute("customer", savedCustomer);
        // Returns the name of the view to be rendered, in this case "account"
        return "account";
    }

    // Maps HTTP GET requests for the "/account" URL to this method
    @GetMapping("/account")
    @Transactional
    public  String accountForm(Model model) {
        // Adds a new Account object to the model to be used in the account creation form
        model.addAttribute("account", new Account());
        // Returns the name of the view to be rendered, in this case "account"
        return  "account";
    }

    // Maps HTTP POST requests for the "/account" URL to this method
    @PostMapping("/account")
    @Transactional
    public String createAccount(@RequestParam Long id, @RequestParam  String accountType, @RequestParam  double intialDeposit, Model model) {
        // Calls the bankService to create a new account with the provided customer ID, account type, and intialDeposit
        Account account = bankServices.createAccount(id,accountType,intialDeposit);
        // Adds the created account object to the model to be accessed in the view
        model.addAttribute("sccount",account);
        // Returns the name of the view to be rendered, in this case "account created successful"
        return "account created successful";

    }


}
