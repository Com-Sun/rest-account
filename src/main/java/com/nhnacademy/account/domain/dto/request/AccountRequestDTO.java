package com.nhnacademy.account.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRequestDTO {
    private String accountId;
    private String accountPwd;
    private String accountMail;
}
