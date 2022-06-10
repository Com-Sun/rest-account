package com.nhnacademy.account.domain.dto.request;

import com.nhnacademy.account.entity.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountAuthorityRequestDTO {
    private Account account;
    private String accountAuth;
}
