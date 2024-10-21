package com.example.demo.Repositories;

import com.example.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// entity to interact with the database
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    }


