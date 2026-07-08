package org.example.ch3_develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {

    private final Long id;
    private final String title;
    private final String name;
    private final String content;
    private final LocalDateTime created;
    private final LocalDateTime modified;

    public GetScheduleResponse(Long id, String title, String name, String content, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.content = content;
        this.created = created;
        this.modified = modified;
    }
}
