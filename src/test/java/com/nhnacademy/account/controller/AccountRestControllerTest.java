package com.nhnacademy.account.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
class AccountRestControllerTest {
    @SpyBean
    AccountRepository accountRepository;
    @Autowired
    MockMvc mvc;

    @DisplayName("API - Account 등록 테스트")
    @Test
    void createAccountTest() throws Exception {
        AccountRequestDTO hyun = AccountRequestDTO.builder()
            .accountId("hyunjin")
            .accountMail("hyunjin@nhn.com")
            .accountPwd("hyunjin")
            .build();
        String requestBody = new ObjectMapper().writeValueAsString(hyun);

        this.mvc.perform(
                post("/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
            ).andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.accountId", equalTo("hyunjin")));
    }

    @DisplayName("API - Account 전체 조회 테스트")
    @Test
    void readAllAccountsTest() throws Exception {
        AccountRequestDTO hyun = AccountRequestDTO.builder()
            .accountId("hyunjin")
            .accountMail("hyunjin@nhn.com")
            .accountPwd("hyunjin")
            .build();
        String requestBody = new ObjectMapper().writeValueAsString(hyun);

        this.mvc.perform(
            post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        this.mvc.perform(
            get(("/accounts"))
        ).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].accountId", equalTo("hyunjin")));
    }

    @DisplayName("API - Account 삭제시 속성이 deleted로 변했는지 테스트")
    @Test
    void deletedStateAccountTest() throws Exception {
        given(accountRepository.findById(1L))
            .willReturn(Optional.of(Account.builder()
                    .accountId("hyunjin")
                    .accountPwd("hyunjin")
                    .accountMail("hyunjin@nhn.com")
                .build()));

        this.mvc.perform(
                post("/accounts/{accountNum}", 1L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.accountStatus", equalTo("deleted")));
    }

    @DisplayName("API - Account의 state를 바꾸는것이 아닌 db에서 삭제 테스트")
    @Test
    void deleteAccountTest() throws Exception {
        this.mvc.perform(
                delete("/accounts/delete/{accountNum}", 1L))
            .andExpect(status().isOk());
    }

}