package com.example.mybootstrap.repository;



import com.example.mybootstrap.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    User getUserById(long id);
}
