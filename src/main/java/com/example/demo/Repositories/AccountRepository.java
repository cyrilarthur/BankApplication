package com.example.demo.Repositories;

import com.example.demo.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    //entity to interact with the database
    public interface AccountRepository extends JpaRepository<Account, Long> {

    }
