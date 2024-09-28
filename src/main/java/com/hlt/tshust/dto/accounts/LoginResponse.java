package com.hlt.tshust.dto.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean auth;
    private String accesstoken;
    private String refreshToken;
    private Integer accountId;
    private String role;
}
