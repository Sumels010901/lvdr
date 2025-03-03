package com.sumels.lvdr.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

@Data
@Entity
@Table(name="lvdr_couple")
@DynamicInsert
@DynamicUpdate
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String user1;
    private String user2;
    private Date startDate;
}
