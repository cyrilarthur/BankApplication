package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key

    private String name;
    private String email;

    public Customer() {
    }

    public Customer(String name, String email) {
//        if (id == null) {
//            throw new IllegalArgumentException("customers id cannot be null"); // prevents Id from null
//        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
//        if (id == null) {
//            throw new IllegalArgumentException("customer id cannot be null"); // checks for null
//        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
