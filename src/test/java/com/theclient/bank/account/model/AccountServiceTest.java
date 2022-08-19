package com.theclient.bank.account.model;

import com.theclient.bank.account.exception.WrongCurrencyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class AccountServiceTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        service = new AccountService();
    }

    @Test
    void depositToAccount_callFindAccountByDto() throws WrongCurrencyException {
        // setup
        AccountDto mockAccountDto = mock(AccountDto.class);
        BigDecimal amount = BigDecimal.valueOf(1000);
        final Currency usd = Currency.getInstance("USD");
        service = spy(service);
        Account mockAccount = mock(Account.class);
        doReturn(mockAccount).when(service).findAccountByDto(any());
        doNothing().when(service).checkForCurrency(any(), any());

        // act
        service.depositToAccount(mockAccountDto, amount, usd);

        // verify
        verify(service).findAccountByDto(mockAccountDto);
    }

    @Test
    void depositToAccount_callCheckForCurrency() throws WrongCurrencyException {
        // setup
        AccountDto mockAccountDto = mock(AccountDto.class);
        BigDecimal amount = BigDecimal.valueOf(1000);
        final Currency usd = Currency.getInstance("USD");
        service = spy(service);
        Account mockAccount = mock(Account.class);
        doReturn(mockAccount).when(service).findAccountByDto(any());
        doNothing().when(service).checkForCurrency(any(), any());

        // act
        service.depositToAccount(mockAccountDto, amount, usd);

        // verify
        verify(service).checkForCurrency(mockAccount, usd);
    }

    @Test
    void depositToAccount_callAccountIncreaseBalance() throws WrongCurrencyException {
        // setup
        AccountDto mockAccountDto = mock(AccountDto.class);
        BigDecimal amount = BigDecimal.valueOf(1000);
        final Currency usd = Currency.getInstance("USD");
        service = spy(service);
        Account mockAccount = mock(Account.class);
        doReturn(mockAccount).when(service).findAccountByDto(any());
        doNothing().when(service).checkForCurrency(any(), any());

        // act
        service.depositToAccount(mockAccountDto, amount, usd);

        // verify
        verify(mockAccount).increaseBalance(amount);
    }

    @Test
    void depositToAccount_callMapToDto() throws WrongCurrencyException {
        // setup
        AccountDto mockAccountDto = mock(AccountDto.class);
        BigDecimal amount = BigDecimal.valueOf(1000);
        final Currency usd = Currency.getInstance("USD");
        service = spy(service);
        Account mockAccount = mock(Account.class);
        doReturn(mockAccount).when(service).findAccountByDto(any());
        doNothing().when(service).checkForCurrency(any(), any());

        // act
        service.depositToAccount(mockAccountDto, amount, usd);

        // verify
        verify(service).maoToDto(mockAccount);
    }
    @Test
    void depositToAccount_checkResult() throws WrongCurrencyException {
        // setup
        AccountDto mockAccountDto = mock(AccountDto.class);
        BigDecimal amount = BigDecimal.valueOf(1000);
        final Currency usd = Currency.getInstance("USD");
        service = spy(service);
        Account mockAccount = mock(Account.class);
        doReturn(mockAccount).when(service).findAccountByDto(any());
        doNothing().when(service).checkForCurrency(any(), any());
        AccountDto mockNewAccountDto = mock(AccountDto.class);
        doReturn(mockNewAccountDto).when(service).maoToDto(any());

        // act
        final AccountDto result = service.depositToAccount(mockAccountDto, amount, usd);

        // verify
        assertThat(result, is(mockNewAccountDto));
    }

}