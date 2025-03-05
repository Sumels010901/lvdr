package com.sumels.lvdr.service.impl;

import com.sumels.lvdr.exception.DuplicateEntryException;
import com.sumels.lvdr.exception.NotFoundException;
import com.sumels.lvdr.entity.User;
import com.sumels.lvdr.repository.UserRepository;
import com.sumels.lvdr.service.UserService;
import com.sumels.lvdr.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User createUser(User user) {
        user.setCode(CodeGenerator.generateCode(8));
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateEntryException("Username existed");
        }
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEntryException("Email used");
        }
        return repo.save(user);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return repo.findAll(pageable);
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
