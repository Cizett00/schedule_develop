package org.example.ch3_develop.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
