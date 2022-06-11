package com.nhnacademy.account.domain.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountLoginRequestDTO {
    @NotBlank(message = "아이디가 공백으로 인한 에러")
    private String accountId;
}
