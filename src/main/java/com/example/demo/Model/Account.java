package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber; // primary key

    private String accountType;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;

    public Account() {
    }

    public Account(Long accountNumber, String accountType, double balance, Customer customer) {
//        if (accountNumber == null) {
//            throw  new IllegalArgumentException("account number cannot be null"); // checks for null
//        }
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public Account(String accountType, double intialDeposit, Customer customer) {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
//        if (accountNumber == null) {
//            throw new IllegalArgumentException("account number cannot be null"); // checks for null
//        }
//        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
