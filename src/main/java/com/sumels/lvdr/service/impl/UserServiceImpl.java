package com.sumels.lvdr.service.impl;

import com.sumels.lvdr.exception.NotFoundException;
import com.sumels.lvdr.model.User;
import com.sumels.lvdr.repository.UserRepository;
import com.sumels.lvdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return repo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Username not found"));
    }

    public User getById(Long id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User ID not found"));
    }

    @Override
    public User updateUser(User user) {
        return repo.save(user);
    }

    @Override
    public User softDeleteUser(User user) {
        user.setIsDelete(true);
        return repo.save(user);
    }
}
