package com.nhnacademy.account.service;

import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public List<AccountRequestDTO> getAllAccounts() {
        return null;
    }

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {
        return null;
    }

    @Override
    public AccountResponseDTO updateAccount(Long accountNum, AccountRequestDTO requestDTO) {
        return null;
    }

    @Override
    public AccountResponseDTO deleteAccount(String memberId) {
        return null;
    }
}
