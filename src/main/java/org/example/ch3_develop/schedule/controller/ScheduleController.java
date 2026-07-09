package org.example.ch3_develop.schedule.controller;

import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CreateScheduleResponse> CreateSchedule(
            @RequestBody CreateScheduleRequest createScheduleRequest,
            HttpSession session){
        if(session.getAttribute("LoginUser") == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        CreateScheduleResponse result = scheduleService.createSchedule(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
//    @GetMapping("/schedules")
//    public ResponseEntity<List<GetScheduleResponse>> GetAllSchedule(@RequestParam(required = false) String name){
//        List<GetScheduleResponse> result = scheduleService.getAllSchedule(name);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }

    @GetMapping
    public ResponseEntity<List<GetScheduleResponse>> GetAllSchedule(){
        List<GetScheduleResponse> result = scheduleService.getAllSchedule();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetScheduleResponse> GetSchedule(@PathVariable Long id){
        GetScheduleResponse result = scheduleService.getSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponse> UpdateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequest request,
            HttpSession session){
        if(session.getAttribute("LoginUser") == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        UpdateScheduleResponse result = scheduleService.updateSchedule(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteSchedule(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequest request,
            HttpSession session){
        if(session.getAttribute("LoginUser") == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        scheduleService.deleteSchedule(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
