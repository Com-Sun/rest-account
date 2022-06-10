package com.nhnacademy.account.service;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.account.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Test
    void getAllAccounts() {
    }

    @Test
    void createAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
    }
}