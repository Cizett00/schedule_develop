package org.example.ch3_develop.schedule.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.ch3_develop.schedule.dto.*;
import org.example.ch3_develop.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @GetMapping("/schedules/{id}")
    public ResponseEntity<GetScheduleResponse> GetSchedule(@PathVariable Long id){
        GetScheduleResponse result = scheduleService.getSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<UpdateScheduleResponse> UpdateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequest request){
        UpdateScheduleResponse result = scheduleService.updateSchedule(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> DeleteSchedule(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequest request){
        scheduleService.deleteSchedule(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
