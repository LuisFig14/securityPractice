package com.practice.security.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String role; //example : "ROLE_USER" o "ROLE_ADMIN"

}
