package com.sumels.lvdr.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="lvdr_user")
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;
    private Date dob;
    private String gender;
    private String description;
    private Blob avatar;
    private String code;
    private Boolean available;
    private Boolean isAdmin;
    private Date lastUpdate;
    private Boolean isDelete;
}
