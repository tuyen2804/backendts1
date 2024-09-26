package com.hlt.tshust.service;

import com.hlt.tshust.model.Accounts;
import com.hlt.tshust.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Accounts save(Accounts accounts) {
        accounts.setPassword(bCryptPasswordEncoder.encode(accounts.getPassword()));
        return accountRepository.save(accounts);
    }

    public Accounts findByUseremail(String email) {
        return accountRepository.findByEmail(email).orElse(null);
    }
}

