package org.example.ch3_develop.schedule.dto;

import lombok.Getter;
import org.example.ch3_develop.user.User;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String content;
    private Long user_id;
}
