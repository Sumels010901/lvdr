package com.sumels.lvdr.service;

import com.sumels.lvdr.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);
    Page<User> getAllUsers(Pageable pageable);
    User getByUsername(String username);
    User getById(Long id);
    User updateUser(User user);
    User softDeleteUser(User user);
}
