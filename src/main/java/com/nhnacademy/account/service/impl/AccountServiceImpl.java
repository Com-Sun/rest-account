package com.nhnacademy.account.service.impl;

import com.nhnacademy.account.domain.dto.request.AccountModifyRequestDTO;
import com.nhnacademy.account.domain.dto.request.AccountRequestDTO;
import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.entity.Account;
import com.nhnacademy.account.exception.NotFoundAccountException;
import com.nhnacademy.account.repository.AccountRepository;
import com.nhnacademy.account.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {
        Account account = Account.builder()
            .accountId(requestDTO.getAccountId())
            .accountPwd(requestDTO.getAccountPwd())
            .accountMail(requestDTO.getAccountMail())
            .build();

        accountRepository.save(account);

        // 여기서 dto를 새로 만들어서 리턴
        // 혹은 객체 그 자체를 굳이 반환할 필요는 없음. 그냥 boolean반환을 생각해봐
        return accountRepository.queryByAccountNum(account.getAccountNum());
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAllBy();
    }

    @Override
    public AccountResponseDTO updateAccount(Long accountNum, AccountModifyRequestDTO requestDTO) {
        Account account = accountRepository.findById(accountNum).orElseThrow(() -> new NotFoundAccountException("해당 회원이 존재하지 않습니다."));
        account.setAccountPwd(requestDTO.getAccountPwd());
        accountRepository.save(account);
        return accountRepository.findByAccountId(requestDTO.getAccountId());
    }

    @Override
    public AccountResponseDTO deleteAccount(String memberId) {
        return null;
    }
}
