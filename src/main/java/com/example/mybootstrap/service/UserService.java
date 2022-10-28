package com.example.mybootstrap.service;


import com.example.mybootstrap.repository.UserRepository;
import com.example.mybootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements  UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveUser(user);
    }
    @Transactional
    public void updateUser(User user) {
        if (!user.getPassword().equals(userRepository.getUserById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.updateUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }


    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }


    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.getUserByLogin(login);
    }
}
