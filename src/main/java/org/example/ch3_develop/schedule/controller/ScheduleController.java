package org.example.ch3_develop.schedule.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.ch3_develop.schedule.dto.CreateScheduleRequest;
import org.example.ch3_develop.schedule.dto.CreateScheduleResponse;
import org.example.ch3_develop.schedule.dto.GetScheduleResponse;
import org.example.ch3_develop.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> CreateSchedule(@RequestBody CreateScheduleRequest createScheduleRequest){
        CreateScheduleResponse result = scheduleService.createSchedule(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
//    @GetMapping("/schedules")
//    public ResponseEntity<List<GetScheduleResponse>> GetAllSchedule(@RequestParam(required = false) String name){
//        List<GetScheduleResponse> result = scheduleService.getAllSchedule(name);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> GetAllSchedule(){
        List<GetScheduleResponse> result = scheduleService.getAllSchedule();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
