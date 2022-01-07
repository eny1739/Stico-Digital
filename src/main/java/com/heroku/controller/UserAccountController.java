package com.heroku.controller;

import com.heroku.dto.UserCredential;
import com.heroku.entity.UserAccount;
import com.heroku.service.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountServiceImpl userAccountService;


    @GetMapping("/api/users")
    public List<UserAccount> findAllBooks(){
        return userAccountService.findAll();
    }

    @GetMapping("/api/user/{id}")
    public UserAccount getById(@PathVariable(name = "id") String id) {
        return userAccountService.getById(id);
    }

    @PostMapping("/api/user")
    public UserAccount createUser(@RequestBody UserAccount userAccount){
        return userAccountService.create(userAccount);
    }

    @PostMapping("/api/signin")
    public Map<String, Object> signin(@RequestBody UserCredential userCredential){
        return userAccountService.signIn(userCredential);
    }

    @PostMapping("/api/register")
    public UserAccount registerAccount(@RequestBody UserAccount userAccount){
        return userAccountService.register(userAccount);
    }

    @DeleteMapping("/api/user/{id}")
    public void deleteById(@PathVariable(name = "id") String id){
        userAccountService.deleteById(id);
    }

    @PutMapping("/api/user")
    public UserAccount update(@RequestBody UserAccount userAccount) {
        return userAccountService.update(userAccount);
    }
}
