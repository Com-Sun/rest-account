package com.nhnacademy.account.repository;

import com.nhnacademy.account.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.account.entity.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    AccountResponseDTO findByAccountId(String accountId);
    AccountResponseDTO queryByAccountNum(Long accountNum);
    List<AccountResponseDTO> findAllBy();

    Optional<Account> queryByAccountId(String accountId);
}
