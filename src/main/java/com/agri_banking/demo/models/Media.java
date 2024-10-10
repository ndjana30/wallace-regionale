package com.agri_banking.demo.models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "media")
@Entity
@Data
public class Media {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private byte[] images;
}
