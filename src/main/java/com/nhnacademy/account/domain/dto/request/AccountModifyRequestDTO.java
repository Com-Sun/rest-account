package com.nhnacademy.account.domain.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModifyRequestDTO {
    private String accountId;
    @NotBlank(message = "비밀번호가 공백으로 인한 에러")
    private String accountPwd;
}
