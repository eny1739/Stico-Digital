package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void create(User user) {
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

//    @Override
    public void update(User user) {
    }
}
