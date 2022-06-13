package com.nhnacademy.account.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;
    private Account account;
    @BeforeEach
    void setUp() {
        account = Account.builder()
            .accountId("hyunjin")
            .accountPwd("hyunjin")
            .accountMail("hyunjin@nhnacdemy.com")
            .build();
    }

    @Test
    public void findByAccountIdTest() {
        accountRepository.save(account);
        AccountResponseDTO hyunjin = accountRepository.findByAccountId("hyunjin");
        assertThat(hyunjin).isNotNull();
        assertThat(hyunjin.getAccountId()).isEqualTo("hyunjin");

    }

    @Test
    public void getAllTest() {
        accountRepository.save(account);
        assertThat(accountRepository.findAll()).isNotNull();
    }

    @Test
    public void deleteTest() {
        accountRepository.save(account);
        accountRepository.delete(account);
        assertThat(accountRepository.findById(account.getAccountNum())).isNotPresent();
    }

}