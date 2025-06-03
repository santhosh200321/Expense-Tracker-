package com.backend.User_service.Service;

import com.backend.User_service.Entity.User;
import com.backend.User_service.Repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User register(User user) {
        return userRepository.save(user); // New user
    }

    public boolean login(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword());
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public boolean authorized(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser.get().isAuthorised();
    }
}
