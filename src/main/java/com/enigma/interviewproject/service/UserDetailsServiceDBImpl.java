package com.enigma.interviewproject.service;

import com.enigma.interviewproject.dto.UserDetailImpl;
import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceDBImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.getUsernameUser(username).isPresent()){
            throw new UsernameNotFoundException("Username tidak ditemukan");
        }
        UserAccount userAccount = userRepository.getUsernameUser(username).get();
        UserDetails userDetails = new UserDetailImpl(userAccount.getUsername(),userAccount.getPassword());
        return userDetails;
    }
}
