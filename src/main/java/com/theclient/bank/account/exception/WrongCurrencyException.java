package com.theclient.bank.account.exception;

public class WrongCurrencyException extends Exception {
    public WrongCurrencyException(String message) {
        super(message);
    }
}
