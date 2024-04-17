package com.walterverse.bankingApp.controller;


import com.walterverse.bankingApp.dto.AccountDto;
import com.walterverse.bankingApp.services.AccountServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountServices accountService;

    public AccountController(AccountServices accountService) {
        this.accountService = accountService;
    }
    //adding account
@PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
    return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
}
//getting account
@GetMapping("/{id}")
public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
}
//depositing
    @PutMapping("/{id/deposit }  ")
 public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){

        Double amount= request.get("amount");

       AccountDto accountDto= accountService.deposit(id,amount);
       return ResponseEntity.ok(accountDto);
 }
//withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody
                                               Map<String, Double> request){

        double amount=request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);

        return ResponseEntity.ok(accountDto);
    }

    //getting all accounts
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
      List<AccountDto> accounts = accountService.getAllAccounts();
      return ResponseEntity.ok(accounts);


    }
    //deleting account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("accountis deleted successfully");
    }

}
