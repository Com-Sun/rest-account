package com.nhnacademy.account.service;

import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.entity.Account;
import java.util.List;

public interface AccountService {
    List<AccountRequestDTO> getAllAccounts();
    AccountResponseDTO createAccount(AccountRequestDTO requestDTO);
    AccountResponseDTO updateAccount(Long accountNum, AccountRequestDTO requestDTO);
    AccountResponseDTO deleteAccount(String memberId);
}
