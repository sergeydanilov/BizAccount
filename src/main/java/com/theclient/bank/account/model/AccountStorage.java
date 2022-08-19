package com.theclient.bank.account.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This is not thread safe. Just for example.
 */
public final class AccountStorage {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void addAccount(AccountDto dto) {
        if (!accounts.containsKey(dto.getUuid())) {
            final String uuid = dto.getUuid();
            final Account account = new Account(uuid, dto.getCurrency(), dto.getUser(), dto.getBalance());
            accounts.put(uuid, account);
        }
    }

    static Account getAccount(String uuid) {
        return accounts.get(uuid);
    }

    private AccountStorage() {
    }
}
