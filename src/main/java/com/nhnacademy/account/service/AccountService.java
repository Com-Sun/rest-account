package com.nhnacademy.account.service;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import java.util.List;

public interface AccountService {
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO createAccount(AccountRequestDTO requestDTO);
    AccountResponseDTO updateAccount(Long accountNum , AccountModifyRequestDTO requestDTO);
    boolean deleteAccount(Long accountNum);
}
