package com.nhnacademy.account.controller;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.service.AccountService;
import java.util.List;
import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/accounts")
    public AccountResponseDTO createAccount(@RequestBody @Valid AccountRequestDTO requestDTO) {
        return accountService.createAccount(requestDTO);
    }
    @GetMapping(value = "/accounts")
    public List<AccountResponseDTO> readAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PutMapping(value = "/accounts/{accountNum}")
    public AccountResponseDTO updateAccount(@RequestBody @Valid AccountModifyRequestDTO requestDTO, @PathVariable(name = "accountNum") Long accountNum) {
        return accountService.updateAccount(accountNum, requestDTO);
    }

    @PostMapping(value = "/accounts/{accountNum}")
    public AccountResponseDTO deleteAccountState(@PathVariable(name = "accountNum") Long accountNum) {
        return accountService.changeAccountStateToDelete(accountNum);
    }

    @DeleteMapping(value = "/accounts/{accountNum}")
    boolean deleteAccount(@PathVariable(name = "accountNum") Long accountNum) {
        return accountService.deleteAccount(accountNum);
    }

    @PostMapping(value = "/accounts/login")
    public ResponseEntity<AccountResponseDTO> login(@RequestBody AccountModifyRequestDTO requestDTO)
        throws AccountNotFoundException {

        AccountResponseDTO responseDTO = accountService.doLogin(requestDTO);

        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(responseDTO);
    }

}
