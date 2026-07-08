package org.example.ch3_develop.schedule.repository;

import aQute.bnd.annotation.jpms.Open;
import org.example.ch3_develop.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByTitle(String title);
}
