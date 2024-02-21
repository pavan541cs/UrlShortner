package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setCreationDate(new Date());
        return userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        if(userRepository.existsById(id)) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
