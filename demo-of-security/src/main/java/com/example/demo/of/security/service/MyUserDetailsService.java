package com.example.demo.of.security.service;

import com.example.demo.of.security.dao.UserRepo;
import com.example.demo.of.security.model.User;
import com.example.demo.of.security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if (user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not found");
        }

        return new UserPrincipal(user);
    }
}
