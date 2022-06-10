package com.nhnacademy.account.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.repository.AccountRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;
    private Account account;
    private AccountRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        account = Account.builder()
            .accountId("hyunjin")
            .accountPwd("hyunjin")
            .accountMail("hyunjin@nhn.com")
            .build();

        requestDTO = AccountRequestDTO.builder()
            .accountId("hyunjin")
            .accountPwd("hyunjin")
            .accountMail("hyunjin@nhn.com")
            .build();

    }

    @Test
    void createAccountTest() {
        accountService.createAccount(requestDTO);
        verify(accountRepository, atLeastOnce()).save(any());

    }

    @Test
    void getAllAccountsTest() {
        accountService.getAllAccounts();
        verify(accountRepository, atLeastOnce()).findAllBy();
    }

    @Test
    void updateAccountTest() {

        given(accountRepository.findById(any()))
            .willReturn(Optional.of(account));

        AccountModifyRequestDTO modifyrequestDTO = AccountModifyRequestDTO.builder()
            .accountId("hyunjin")
            .accountPwd("modifiedPwd")
            .build();
        accountService.updateAccount(1L, modifyrequestDTO);

        verify(accountRepository, atLeastOnce()).findById(any());
        verify(accountRepository, atLeastOnce()).findByAccountId(any());
        verify(accountRepository, atLeastOnce()).save(any());


    }

    @Test
    void deleteAccount() {
    }
}