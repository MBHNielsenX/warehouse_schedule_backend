package com.example.warehouse_schedule_backend.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String username;
    String password;
}
