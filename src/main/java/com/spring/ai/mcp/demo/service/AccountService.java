package com.spring.ai.mcp.demo.service;

import com.spring.ai.mcp.demo.entity.AccountInfo;
import com.spring.ai.mcp.demo.repositoties.AccountRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Tool(name = "addAccountInfo", description = "Add Account Information if not exists in database")
    public String addAccountInfo(@ToolParam String name, @ToolParam Integer accountNumber, @ToolParam Double amount) {
        AccountInfo accountInfo = new AccountInfo().toBuilder().name(name).accountNumber(accountNumber).amount(amount).build();
        accountRepository.save(accountInfo);
        return "Account Information saved successfully.";
    }

    @Tool(name="getBalance", description = "get the account balance if exists in the database")
    public String getBalance(@ToolParam String name, @ToolParam Integer accountNumber) {
        Double amount = 0.0;
        if(accountNumber != null)
            amount = accountRepository.getAmountByAccountNumber(accountNumber);
        if(name != null)
            amount = accountRepository.getAmountByName(name);
        return "Account Balance is :" + amount;
    }

    @Tool(name = "getAccountInfo", description = "get the account information for given account number")
    public AccountInfo getAccountInfo(@ToolParam Integer accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
