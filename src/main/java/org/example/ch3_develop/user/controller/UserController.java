package org.example.ch3_develop.user.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    // 회원가입
    @PostMapping
    public ResponseEntity<CreateUserResponse> signUp(
            @RequestBody CreateUserRequest request){
        CreateUserResponse result = userService.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //로그인 로그아웃
    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request, HttpSession session){
        SessionUser sessionUser = userService.login(request);
        session.setAttribute("LoginUser", sessionUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        session.invalidate();

        return ResponseEntity.status(HttpStatus.OK).build();
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
            @RequestBody UpdateUserRequest request,
            HttpSession session){
        if(session.getAttribute("LoginUser") == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        UpdateUserResponse result = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUser(
            @PathVariable Long id,
            @RequestBody DeleteUserRequest request,
            HttpSession session){
        if(session.getAttribute("LoginUser") == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        userService.deleteUser(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
