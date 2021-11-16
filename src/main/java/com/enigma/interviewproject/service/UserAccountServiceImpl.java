package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserAccount create(UserAccount userAccount) {
        String uuid = getUuid();
        while (userRepository.findById(uuid).isPresent()){
            uuid = getUuid();
        }
        String password = getEncodePassword(userAccount);
        userRepository.createUser(uuid, userAccount.getName(), userAccount.getEmail(), userAccount.getPhoneNumber(), userAccount.getAddress(), userAccount.getMotherName(), userAccount.getAccountNumber(), userAccount.getUsername(), password);
        return getById(uuid);
    }

    public UserAccount register(UserAccount userAccount){
        String uuid = getUuid();
        while (userRepository.findById(uuid).isPresent()){
            uuid = getUuid();
        }
        String password = getEncodePassword(userAccount);
        userRepository.registerAccount(uuid, userAccount.getUsername(), password);
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
        return userRepository.getAllUser();
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserAccount getById(String id) {
        UserAccount userAccount = userRepository.getById(id);
        if (userAccount == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User tidak ditemukan");
        }
        return userAccount;
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        getById(userAccount.getId());
        userRepository.updateBook(userAccount.getId(), userAccount.getName(), userAccount.getEmail(), userAccount.getPhoneNumber(), userAccount.getAddress(), userAccount.getMotherName(), userAccount.getAccountNumber(), userAccount.getUsername(), userAccount.getPassword());
        return userAccount;
    }

}
