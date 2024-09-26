package com.hlt.tshust.dto.accounts;

import lombok.Data;

@Data
public class RegisterRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private String password;
}

