package com.theclient.bank.account.exception;

public class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}
