package com.nhnacademy.account.service.impl;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.exception.NotFoundAccountException;
import com.nhnacademy.account.repository.AccountRepository;
import com.nhnacademy.account.service.AccountService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {
        Account account = Account.builder()
            .accountId(requestDTO.getAccountId())
            .accountPwd(requestDTO.getAccountPwd())
            .accountMail(requestDTO.getAccountMail())
            .build();

        accountRepository.save(account);

        return accountRepository.queryByAccountNum(account.getAccountNum());
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAllBy();
    }

    @Transactional
    @Override
    public AccountResponseDTO updateAccount(Long accountNum, AccountModifyRequestDTO requestDTO) {
        Account account = accountRepository.findById(accountNum).orElseThrow(() -> new NotFoundAccountException("해당 회원이 존재하지 않습니다."));
        account.setAccountPwd(requestDTO.getAccountPwd());
        accountRepository.save(account);
        return accountRepository.findByAccountId(requestDTO.getAccountId());
    }

    @Transactional
    @Override
    public AccountResponseDTO changeAccountStateToDelete(Long accountNum) {
        Account account = accountRepository.findById(accountNum).orElseThrow(() -> new NotFoundAccountException("계정이 유효하지 않습니다."));
        account.setAccountStatus("deleted");
        accountRepository.save(account);
        return accountRepository.findByAccountId(account.getAccountId());
    }

    @Transactional
    @Override
    public boolean deleteAccount(Long accountNum) {
        Optional<Account> account = accountRepository.findById(accountNum);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
            return true;
        }
        return false;
    }
}
