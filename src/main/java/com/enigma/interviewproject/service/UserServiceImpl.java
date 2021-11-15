package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.Book;
import com.enigma.interviewproject.entity.User;
import com.enigma.interviewproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        while (userRepository.findById(uuid).isPresent()){
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        userRepository.createUser(uuid, user.getName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getMotherName(), user.getAccountNumber(), user.getUsername(), user.getPassword());
        return getById(uuid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllUser();
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User getById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User tidak ditemukan");
        }
        return userOptional.get();
    }

    @Override
    public User update(User user) {
        getById(user.getId());
        userRepository.updateBook(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getMotherName(), user.getAccountNumber(), user.getUsername(), user.getPassword());
        return user;
    }
}
