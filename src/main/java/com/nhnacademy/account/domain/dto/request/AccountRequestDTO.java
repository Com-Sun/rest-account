package com.nhnacademy.account.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRequestDTO {
    @NotBlank(message = "아이디가 공백으로 인한 에러")
    private String accountId;
    @NotBlank(message = "비밀번호가 공백으로 인한 에러")
    private String accountPwd;
    @NotBlank(message = "메일이 공백으로 인한 에러")
    @Email(message = "유효하지 않은 메일로 인한 에러")
    private String accountMail;
}
