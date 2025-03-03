package com.sumels.lvdr.service;

import com.sumels.lvdr.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getByUsername(String username);
    User updateUser(User user);
    User softDeleteUser(User user);
}
