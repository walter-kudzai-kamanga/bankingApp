package com.walterverse.bankingApp.services;

import com.walterverse.bankingApp.dto.AccountDto;
import com.walterverse.bankingApp.entity.Account;

import java.util.List;

public interface AccountServices {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);

    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);


}
