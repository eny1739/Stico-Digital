package com.enigma.interviewproject.controller;

import com.enigma.interviewproject.entity.Book;
import com.enigma.interviewproject.entity.User;
import com.enigma.interviewproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAllBooks(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable(name = "id") String id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable(name = "id") String id){
        userService.deleteById(id);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
