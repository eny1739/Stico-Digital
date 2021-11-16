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

    @Autowired
    UserDetailsServiceDBImpl userDetailsServiceDB;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;



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

    @PostMapping("/login")
    public Map<String, Object> signin(@RequestBody UserCredential userCredential){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userCredential.getUsername(), userCredential.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetails userDetails = userDetailsServiceDB.loadUserByUsername(userCredential.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);
        return tokenWrapper;
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
