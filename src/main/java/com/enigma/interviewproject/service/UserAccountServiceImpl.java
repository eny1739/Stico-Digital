package com.enigma.interviewproject.service;

import com.enigma.interviewproject.dto.UserCredential;
import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.repo.UserAccountRepository;
import com.enigma.interviewproject.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceDBImpl userDetailsServiceDB;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public UserAccount create(UserAccount userAccount) {
        String uuid = getUuid();
        while (userAccountRepository.findById(uuid).isPresent()){
            uuid = getUuid();
        }
        String password = getEncodePassword(userAccount);
        userAccountRepository.createUser(uuid, userAccount.getName(), userAccount.getEmail(), userAccount.getPhoneNumber(), userAccount.getAddress(), userAccount.getMotherName(), userAccount.getAccountNumber(), userAccount.getUsername(), password);
        return getById(uuid);
    }

    public UserAccount register(UserAccount userAccount){
        String uuid = getUuid();
        while (userAccountRepository.findById(uuid).isPresent()){
            uuid = getUuid();
        }
        String password = getEncodePassword(userAccount);
        userAccountRepository.registerAccount(uuid, userAccount.getUsername(), password);
        return getById(uuid);
    }

    private String getEncodePassword(UserAccount userAccount) {
        return userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
    }

    private String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.getAllUser().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        userAccountRepository.deleteById(id);
    }

    @Override
    public UserAccount getById(String id) {
        UserAccount userAccount = userAccountRepository.getById(id);
        if (userAccount == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User tidak ditemukan");
        }
        return userAccount;
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        getById(userAccount.getId());
        userAccountRepository.updateBook(userAccount.getId(), userAccount.getName(), userAccount.getEmail(), userAccount.getPhoneNumber(), userAccount.getAddress(), userAccount.getMotherName(), userAccount.getAccountNumber(), userAccount.getUsername(), userAccount.getPassword());
        return userAccount;
    }

    public Map<String, Object> signIn(UserCredential userCredential) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userCredential.getUsername(),userCredential.getPassword());

        //validate username and password
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetails userDetails = userDetailsServiceDB.loadUserByUsername(userCredential.getUsername());

        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);

        return tokenWrapper;
    }

}
