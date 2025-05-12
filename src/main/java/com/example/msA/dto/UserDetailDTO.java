package com.example.msMiddleware.dto;

import lombok.Data;

@Data
public class UserDetailDTO {
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer status;
}