package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.ChartOfAccount;
import com.greenhouse.hydrothermal.repository.ChartOfAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartOfAccountService {

    private final ChartOfAccountRepository repository;

    public ChartOfAccountService(ChartOfAccountRepository repository) {
        this.repository = repository;
    }

    public ChartOfAccount createAccount(ChartOfAccount account) {
        return repository.save(account);
    }

    public List<ChartOfAccount> getAllAccounts() {
        return repository.findAll();
    }
}