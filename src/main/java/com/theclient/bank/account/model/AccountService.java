package com.theclient.bank.account.model;

import com.theclient.bank.account.exception.LowBalanceException;
import com.theclient.bank.account.exception.WrongCurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class AccountService {

    public Account findAccountByUser(User user) {
        throw new RuntimeException("implement this");
        // find account by user if user has the only account, if not we need to have account id
    }

    public Account findAccountByDto(AccountDto dto) {
        return AccountStorage.getAccount(dto.getUuid());
    }

    public AccountDto depositToAccount(AccountDto dto, BigDecimal amount, Currency currency) throws WrongCurrencyException {
        final Account account = findAccountByDto(dto);
        checkForCurrency(account, currency);
        account.increaseBalance(amount);
        return maoToDto(account);
    }

    public AccountDto withdrawFromAccount(AccountDto dto, BigDecimal amount, Currency currency) throws WrongCurrencyException, LowBalanceException {
        final Account account = findAccountByDto(dto);
        checkForCurrency(account, currency);
        account.decreaseBalance(amount);
        return maoToDto(account);
    }

    void checkForCurrency(Account account, Currency currency) throws WrongCurrencyException {
        if (!Objects.equals(account.getCurrency(), currency)) {
            throw new WrongCurrencyException("passed wrong currency");
        }
    }

    AccountDto maoToDto(Account account) {
        return new AccountDto(account.getUuid(), account.getBalance(), account.getCurrency(), account.getUser());
    }
}
