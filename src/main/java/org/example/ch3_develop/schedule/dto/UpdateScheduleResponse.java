package org.example.ch3_develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final String title;
    private final String content;
    private final LocalDateTime modified;

    public UpdateScheduleResponse(String title, String content, LocalDateTime modified) {
        this.title = title;
        this.content = content;
        this.modified = modified;
    }

}
