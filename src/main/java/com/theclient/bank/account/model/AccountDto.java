package com.theclient.bank.account.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * This is Immutable Object to represent the Account Data
 */
public class AccountDto {
    private final String uuid;
    private final BigDecimal balance;
    private final Currency currency;
    private final User user;

    public AccountDto(String uuid, BigDecimal balance, Currency currency, User user) {
        this.uuid = uuid;
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", user=" + user +
                '}';
    }

    public static AccountDtoBuilder builder() {
        return new AccountDtoBuilder();
    }

    public static class AccountDtoBuilder {
        private String uuid;
        private BigDecimal balance;
        private Currency currency;
        private User user;

        public AccountDtoBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public AccountDtoBuilder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountDtoBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public AccountDtoBuilder user(User user) {
            this.user = user;
            return this;
        }

        public AccountDto build() {
            return new AccountDto(this.uuid, this.balance, this.currency, this.user);
        }
    }
}
