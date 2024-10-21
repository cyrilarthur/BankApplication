package com.example.demo.Services;

import com.example.demo.Model.Account;
import com.example.demo.Model.Customer;
import com.example.demo.Repositories.AccountRepository;
import com.example.demo.Repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BankServices {
    @Autowired
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public BankServices(CustomerRepository customerRepository,AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @PersistenceContext
    private EntityManager entityManager; // Inject EntityManager

    // Register customer
    @Transactional
    public Customer registerCustomer(String name, String email) {
        Customer customer = new Customer(name,email);
        entityManager.flush();
        return customerRepository.save(customer);
    }

    // Method to create account for registered customers
    @Transactional
    public Account createAccount(Long id, String accountType, double intialDeposit) {
        // Checks if the customer is missing (Optional is empty), and if so, throws the exception.
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw  new IllegalArgumentException("customer not found or registered");
        }
        //  Retrieves the Customer object if it's present.
        Customer customer = optionalCustomer.get();
        // then creates accounts
        Account account = new Account(accountType, intialDeposit,customer);
        return accountRepository.save(account);
    }

    // Method to get all customers
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Method to get all accounts
    @Transactional
    public  List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
