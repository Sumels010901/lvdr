package com.sumels.lvdr.dto.user;

import lombok.Data;

import java.sql.Date;

@Data
public class CreateUserRequest {
    private String username;
    private String name;
    private String password;
    private String email;
    private String gender;
    private String description;
    private String code;
    private Date dob;
    private Boolean available;
}
