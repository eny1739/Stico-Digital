package com.enigma.interviewproject.controller;

import com.enigma.interviewproject.dto.UserCredential;
import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.security.JwtTokenUtil;
import com.enigma.interviewproject.service.UserAccountService;
import com.enigma.interviewproject.service.UserAccountServiceImpl;
import com.enigma.interviewproject.service.UserDetailsServiceDBImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

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
