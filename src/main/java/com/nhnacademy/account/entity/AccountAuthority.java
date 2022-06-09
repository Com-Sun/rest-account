package com.nhnacademy.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account_authority")
public class AccountAuthority {
    @Id
    @Column(name = "authority_num")
    private Long authorityNum;

    @ManyToOne
    @JoinColumn(name = "account_num")
    private Account account;

    @Column(name = "account_auth")
    private String accountAuth;

    @Builder(builderClassName = "AccountAuthorityBuilder")
    private AccountAuthority(Long authorityNum, Account account, String accountAuth) {
        this.authorityNum = authorityNum;
        this.account = account;
        this.accountAuth = accountAuth;
    }
}
