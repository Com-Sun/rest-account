package com.nhnacademy.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "account")
@Entity
@EqualsAndHashCode
public class Account {
    @Id
    @Column(name = "account_num")
    private Long accountNum;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_pwd")
    private String accountPwd;

    @Column(name = "account_mail")
    private String accountMail;

    @Builder(builderClassName = "AccountBuilder")
    private Account (Long accountNum, String accountId, String accountPwd, String accountMail) {
        this.accountNum = accountNum;
        this.accountId= accountId;
        this.accountPwd = accountPwd;
        this.accountMail = accountMail;
    }
}
