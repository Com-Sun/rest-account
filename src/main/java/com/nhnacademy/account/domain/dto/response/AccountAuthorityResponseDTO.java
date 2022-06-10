package com.nhnacademy.account.domain.dto.response;

import com.nhnacademy.account.entity.Account;

public interface AccountAuthorityResponseDTO {
    Long getAuthorityNum();
    Account getAccount();
    String getAccountAuth();

}
