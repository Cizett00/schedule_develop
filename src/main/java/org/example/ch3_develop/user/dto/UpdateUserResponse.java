package org.example.ch3_develop.user.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {

    private final String email;
    private final LocalDateTime modified;

    public UpdateUserResponse(String email, LocalDateTime modified) {
        this.email = email;
        this.modified = modified;
    }
}
