package org.example.ch3_develop.schedule.repository;

import org.example.ch3_develop.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
