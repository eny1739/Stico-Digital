package com.enigma.interviewproject.service;

import com.enigma.interviewproject.dto.UserDetailImpl;
import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceDBImpl implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(!userAccountRepository.getUsernameUser(userName).isPresent()){
            throw new UsernameNotFoundException("CANNOT FOUND USERNAME : " + userName);
        }
        UserAccount account = userAccountRepository.getUsernameUser(userName).get();

        UserDetails userDetails = new UserDetailImpl(account.getUsername(), account.getPassword());
        return userDetails;
    }
}