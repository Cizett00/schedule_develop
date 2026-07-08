package org.example.ch3_develop.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.ch3_develop.schedule.Schedule;
import org.example.ch3_develop.schedule.dto.CreateScheduleRequest;
import org.example.ch3_develop.schedule.dto.CreateScheduleResponse;
import org.example.ch3_develop.schedule.dto.GetScheduleResponse;
import org.example.ch3_develop.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request){
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getName(),
                request.getContent()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getName(),
                saveSchedule.getContent(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );
    };

//    @Transactional(readOnly = true)
//    public List<GetScheduleResponse> getAllSchedule(String title){
//        List<Schedule> schedules = scheduleRepository.findAll();
//        List<GetScheduleResponse> dtos = new ArrayList<>();
//
//        for (Schedule schedule : schedules) {
//            GetScheduleResponse dto = new GetScheduleResponse(
//                    schedule.getId(),
//                    schedule.getTitle(),
//                    schedule.getName(),
//                    schedule.getTitle(),
//                    schedule.getCreatedAt(),
//                    schedule.getModifiedAt()
//            );
//            dtos.add(dto);
//        }
//        dtos.sort((dto1, dto2) ->
//                dto2.getModified().compareTo(dto1.getModified())
//        );
//        return dtos;
//    }
@Transactional(readOnly = true)
public List<GetScheduleResponse> getAllSchedule(){
    List<Schedule> schedules = scheduleRepository.findAll();
    List<GetScheduleResponse> dtos = new ArrayList<>();

    for (Schedule schedule : schedules) {
        GetScheduleResponse dto = new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getName(),
                schedule.getTitle(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
        dtos.add(dto);
    }
    dtos.sort((dto1, dto2) ->
            dto2.getModified().compareTo(dto1.getModified())
    );
    return dtos;
}


}
