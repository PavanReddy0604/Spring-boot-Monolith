package com.app.entity;

import com.app.util.Gender;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Person extends Audit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID personId;
    private String personName;
    private Gender gender;

    private Long mobileNumber;
    @OneToOne
    private IdProof proof;


}
