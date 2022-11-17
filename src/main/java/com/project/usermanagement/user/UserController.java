package com.project.usermanagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(id, user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
