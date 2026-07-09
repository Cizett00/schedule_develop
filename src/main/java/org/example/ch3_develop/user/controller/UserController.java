package org.example.ch3_develop.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch3_develop.schedule.dto.*;
import org.example.ch3_develop.schedule.service.ScheduleService;
import org.example.ch3_develop.user.dto.*;
import org.example.ch3_develop.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(
            @RequestBody CreateUserRequest request){
        CreateUserResponse result = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public  ResponseEntity<List<GetUserResponse>> getAllUser(){
        List<GetUserResponse> result = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(
            @PathVariable Long id){
        GetUserResponse result = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> UpdateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request){
        UpdateUserResponse result = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUser(
            @PathVariable Long id,
            @RequestBody DeleteUserRequest request){
        userService.deleteUser(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
