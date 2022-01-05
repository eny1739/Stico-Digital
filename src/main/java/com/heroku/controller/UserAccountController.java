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


    @GetMapping("/users")
    public List<UserAccount> findAllBooks(){
        return userAccountService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserAccount getById(@PathVariable(name = "id") String id) {
        return userAccountService.getById(id);
    }

    @PostMapping("/user")
    public UserAccount createUser(@RequestBody UserAccount userAccount){
        return userAccountService.create(userAccount);
    }

    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody UserCredential userCredential){
        return userAccountService.signIn(userCredential);
    }

    @PostMapping("/register")
    public UserAccount registerAccount(@RequestBody UserAccount userAccount){
        return userAccountService.register(userAccount);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable(name = "id") String id){
        userAccountService.deleteById(id);
    }

    @PutMapping("/user")
    public UserAccount update(@RequestBody UserAccount userAccount) {
        return userAccountService.update(userAccount);
    }
}
