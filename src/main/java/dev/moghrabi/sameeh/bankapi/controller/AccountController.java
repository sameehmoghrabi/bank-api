package dev.moghrabi.sameeh.bankapi.controller;

import dev.moghrabi.sameeh.bankapi.constant.CommonConst;
import dev.moghrabi.sameeh.bankapi.dto.CreateAccountDto;
import dev.moghrabi.sameeh.bankapi.model.Account;
import dev.moghrabi.sameeh.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public String add(@RequestBody @Valid CreateAccountDto createAccountDto) {
        accountService.createAccount(createAccountDto);
        // it can be ResponseEntity
        return CommonConst.Feedback.NEW_ACCOUNT_CREATED;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Account> all() {
        return accountService.getAllAccounts();
    }

}
