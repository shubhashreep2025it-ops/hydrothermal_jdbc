package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.ChartOfAccount;
import com.greenhouse.hydrothermal.service.ChartOfAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class ChartOfAccountController {

    private final ChartOfAccountService service;

    public ChartOfAccountController(ChartOfAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ChartOfAccount createAccount(@RequestBody ChartOfAccount account) {
        return service.createAccount(account);
    }

    @GetMapping
    public List<ChartOfAccount> getAllAccounts() {
        return service.getAllAccounts();
    }
}