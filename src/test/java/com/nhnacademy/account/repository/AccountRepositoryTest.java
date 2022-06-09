package com.nhnacademy.account.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.account.entity.Account;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void saveTest() {
        Account account = Account.builder()
            .accountNum(77L)
            .accountId("hyunjin")
            .accountPwd("hyunjin")
            .accountMail("hyunjin@nhnacdemy.com")
            .build();

        accountRepository.save(account);

        Optional<Account> hyunjin = accountRepository.findById(77L);

        assertThat(hyunjin).isPresent();
        assertThat(hyunjin.orElse(null)).isEqualTo(account);

    }

}