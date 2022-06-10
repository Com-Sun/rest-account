package com.nhnacademy.account.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModifyRequestDTO {
    private String accountId;
    private String accountPwd;
}
