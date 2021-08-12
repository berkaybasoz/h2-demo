package com.h2.demo.controller;

import com.h2.demo.domain.entity.Account;
import com.h2.demo.service.AccountQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountQueryService.getAccountById(accountId);
        return accountOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountQueryService.getAccounts();
    }

}