package org.example.ch3_develop.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String content;
    private String name;
}
