package com.example.msA.dto;

import lombok.Data;

@Data
public class UserDetailDTO {
    private Integer userId;
    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer status;
    private String password;
}