package com.nhnacademy.account.repository;

import com.nhnacademy.account.entity.AccountAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountAuthorityRepository extends JpaRepository<AccountAuthority, Long> {
}
