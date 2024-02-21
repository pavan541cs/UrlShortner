package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public Iterable<User> findAllEmployees() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User addUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user/id")
    public boolean updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
