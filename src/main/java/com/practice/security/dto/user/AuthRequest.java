package com.practice.security.dto.user;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;

}
