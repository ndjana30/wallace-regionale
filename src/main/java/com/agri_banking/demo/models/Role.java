package com.agri_banking.demo.models;


import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String name;
}