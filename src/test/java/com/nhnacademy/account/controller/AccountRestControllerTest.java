package com.nhnacademy.account.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

}