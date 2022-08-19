package com.theclient.bank.account.model;

import com.theclient.bank.account.exception.LowBalanceException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

/**
 * This class can not be used directly
 * Please use AccountService instead
 */
class Account {

    private final String uuid;
    private BigDecimal balance;
    private final Currency currency;
    private final User user;

    Account(Currency currency, User user) {
        this.uuid = UUID.randomUUID().toString();
        this.currency = currency;
        this.user = user;
    }

    Account(String uuid, Currency currency, User user) {
        this.uuid = uuid;
        this.currency = currency;
        this.user = user;
    }

    Account(String uuid, Currency currency, User user, BigDecimal balance) {
        this.uuid = uuid;
        this.currency = currency;
        this.user = user;
        this.balance = balance;
    }

    BigDecimal getBalance() {
        return balance;
    }

    synchronized void increaseBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    synchronized void decreaseBalance(BigDecimal amount) throws LowBalanceException {
        if (balance.compareTo(amount) < 0) {
            throw new LowBalanceException("you do not have enough money : " + this.toString());
        } else {
            this.balance = balance.subtract(amount);
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public User getUser() {
        return user;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return uuid.equals(account.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
