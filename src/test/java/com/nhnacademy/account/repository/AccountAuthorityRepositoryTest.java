package com.nhnacademy.account.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.entity.AccountAuthority;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountAuthorityRepositoryTest {

    @Autowired
    private AccountAuthorityRepository accountAuthorityRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Test
    void saveTest() {
        Account hyunjin = Account.builder()
            .accountId("hyunjin")
            .accountPwd("hyunjin")
            .accountMail("hyunjin@nhnacdemy.com")
            .build();

        accountRepository.save(hyunjin);

        AccountAuthority accountAuthority = AccountAuthority.builder()
            .authorityNum(1L)
            .accountAuth("ADMIN")
            .account(hyunjin)
            .build();

        accountAuthorityRepository.save(accountAuthority);

        Optional<AccountAuthority> authority = accountAuthorityRepository.findById(1L);
        assertThat(authority).isPresent();
        assertThat(authority.orElse(null)).isEqualTo(accountAuthority);
    }
}