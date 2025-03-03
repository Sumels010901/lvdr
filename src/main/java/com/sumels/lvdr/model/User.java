package com.sumels.lvdr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    Long id;
    private String username;
    private String password;
    private Date dob;
    private String gender;
    private String description;
    private Blob avatar;
    private String code;
    private Boolean available;
    private List<User> liked;

}
