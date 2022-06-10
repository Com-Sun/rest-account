package com.nhnacademy.account.controller;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.service.AccountService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    AccountResponseDTO createAccount(@RequestBody @Valid AccountRequestDTO requestDTO) {
        return accountService.createAccount(requestDTO);
    }

    @GetMapping(value = "/accounts")
    List<AccountResponseDTO> readAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PutMapping(value = "/accounts/{accountNum}")
    AccountResponseDTO updateAccount(@RequestBody @Valid AccountModifyRequestDTO requestDTO, @PathVariable(name = "accountNum") Long accountNum) {
        return accountService.updateAccount(accountNum, requestDTO);
    }

    @PostMapping(value = "/accounts/{accountNum}")
    AccountResponseDTO deleteAccountState(@PathVariable(name = "accountNum") Long accountNum) {
        return accountService.changeAccountStateToDelete(accountNum);
    }

    @DeleteMapping(value = "/accounts/delete/{accountNum}")
    boolean deleteAccount(@PathVariable(name = "accountNum") Long accountNum) {
        return accountService.deleteAccount(accountNum);
    }

}
