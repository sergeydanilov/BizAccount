package com.theclient.bank;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Set;

class BankAccountMainTest {

    @Test
    void testCurrency() {
        // setup
        BankAccountMain accountMain = new BankAccountMain();
        final Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
        final Currency usd = Currency.getInstance("USD");

        // act
        availableCurrencies.forEach(System.out::println);
        System.out.println(usd);


        // verify

    }
}