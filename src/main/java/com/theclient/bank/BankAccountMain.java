package com.theclient.bank;

import com.theclient.bank.account.model.AccountDto;
import com.theclient.bank.account.model.AccountService;
import com.theclient.bank.account.model.AccountStorage;
import com.theclient.bank.account.model.User;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public class BankAccountMain {
    public static void main(String[] args) {
        try {
            final AccountService service = new AccountService();
            final Currency usd = Currency.getInstance("USD");
            AccountDto accountDto = AccountDto.builder()
                    .uuid(UUID.randomUUID().toString())
                    .currency(usd)
                    .balance(new BigDecimal(10))
                    .user(new User(1, "serg"))
                    .build();
            AccountStorage.addAccount(accountDto);
            final AccountDto result1 = service.depositToAccount(accountDto, new BigDecimal(1000), usd);
            System.out.println("result1 = " + result1);
            accountDto = AccountDto.builder()
                    .uuid(UUID.randomUUID().toString())
                    .currency(usd)
                    .balance(new BigDecimal(1010))
                    .user(new User(1, "serg"))
                    .build();
            AccountStorage.addAccount(accountDto);
            final AccountDto result2 = service.withdrawFromAccount(accountDto, new BigDecimal(100), usd);
            System.out.println("result2 =" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
