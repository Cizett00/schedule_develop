package org.example.ch3_develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private Long id;
    private final String title;
    private final String name;
    private final String content;
    private final LocalDateTime modified;
    private final LocalDateTime created;

    public CreateScheduleResponse(Long id, String title, String name, String content, LocalDateTime modified, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.content = content;
        this.modified = modified;
        this.created = created;

    }
}
