package com.nhnacademy.account.controller;

import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/accounts")
    AccountResponseDTO createAccount(@RequestBody AccountRequestDTO requestDTO) {
        return accountService.createAccount(requestDTO);
    }

}
