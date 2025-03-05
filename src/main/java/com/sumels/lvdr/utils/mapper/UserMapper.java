package com.sumels.lvdr.utils.mapper;

import com.sumels.lvdr.dto.user.CreateUserRequest;
import com.sumels.lvdr.entity.User;
import com.sumels.lvdr.enums.Gender;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User createRequestToEntity(CreateUserRequest dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setGender(Gender.fromString(dto.getGender()));
        user.setDescription(dto.getDescription());
        user.setCode(dto.getCode());
        user.setDob(dto.getDob());
        user.setAvailable(dto.getAvailable());
        return user;
    }
}
