package com.nhnacademy.account.service;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import java.util.List;
import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO createAccount(AccountRequestDTO requestDTO);
    AccountResponseDTO updateAccount(Long accountNum , AccountModifyRequestDTO requestDTO);
    AccountResponseDTO changeAccountStateToDelete(Long accountNum);
    boolean deleteAccount(Long accountNum);

    AccountResponseDTO doLogin(AccountModifyRequestDTO requestDTO)
        throws AccountNotFoundException;
}
