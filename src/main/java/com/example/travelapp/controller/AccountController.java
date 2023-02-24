package com.example.travelapp.controller;

import com.example.travelapp.request.ChangePassRequest;
import com.example.travelapp.model.Account;
import com.example.travelapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {


    @Autowired
    private AccountService accountService;
    @GetMapping
    public ResponseEntity<?> getListAccount(){
        List<Account> accounts= accountService.listAcount();
        return ResponseEntity.ok(accounts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id){
        Account account= accountService.getAccountByID(id);
        return ResponseEntity.ok(account);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account){

            return  new ResponseEntity<>(accountService.checkLogin(account.getNameAccount(),account.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> creaate(@RequestBody Account account){

        return  new ResponseEntity<>(accountService.createAccount(account),HttpStatus.OK);
    }
    @PostMapping("/lock/{id}")
    public ResponseEntity<?> lockOrUnlock(@PathVariable Long id){
        accountService.lockOrUnlock(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id,@RequestBody Account account){
        return  new ResponseEntity<>(accountService.update(id,account),HttpStatus.OK);
    }
    @PostMapping("/changepassword")
    public ResponseEntity<?> lockOrUnlock(@RequestBody ChangePassRequest changePassRequest){

        return  new ResponseEntity<>(accountService.changePasswprd(changePassRequest),HttpStatus.OK);
    }




}
