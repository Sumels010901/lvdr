package com.sumels.lvdr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Couple {
    @Id
    Long id;
    private String user1;
    private String user2;
    private Date startDate;
}
