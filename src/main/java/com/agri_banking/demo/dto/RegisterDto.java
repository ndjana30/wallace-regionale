package com.agri_banking.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RegisterDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private String nationality;
    private String profession;
    private String residence;
    private String phoneNum;
    private Date dateOfBirth;


}
