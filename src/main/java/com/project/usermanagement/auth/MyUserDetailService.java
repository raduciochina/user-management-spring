package com.project.usermanagement.auth;

import com.project.usermanagement.user.User;
import com.project.usermanagement.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByName(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
        return userDetails;
    }
}
