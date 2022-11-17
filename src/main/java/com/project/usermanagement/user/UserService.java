package com.project.usermanagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }
    public void addUser(User user) {
//        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }
    public void updateUser(String id, User user) {
        userRepository.save(user);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
