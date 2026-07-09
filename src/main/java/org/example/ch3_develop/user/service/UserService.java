package org.example.ch3_develop.user.service;

import jakarta.validation.Valid;
import org.example.ch3_develop.schedule.dto.GetScheduleResponse;
import org.example.ch3_develop.user.dto.*;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ch3_develop.user.User;
import org.example.ch3_develop.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse signUp(CreateUserRequest request){

        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        User savedUser = userRepository.save(user);

        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }
    @Transactional(readOnly = true)
    public SessionUser login(@Valid LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("유효하지 않은 로그인 요청입니다")
        );
        if(!user.getPassword().equals(request.getPassword())){
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다");
        }
        return new SessionUser(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    @Transactional(readOnly = true)
    public List<GetUserResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();

        for (User user : users) {

            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);
        }
        dtos.sort((dto1, dto2) ->
                dto2.getId().compareTo(dto1.getId())
        );
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetUserResponse getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다")
        );
        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public UpdateUserResponse updateUser(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저 입니다.")
        );
        user.update(
                request.getEmail()
        );
        return new UpdateUserResponse(
                user.getEmail(),
                user.getModifiedAt()
        );
    }
    @Transactional
    public void deleteUser(Long id, DeleteUserRequest request){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 유저 입니다.")
        );
        userRepository.deleteById(id);
    }
}
