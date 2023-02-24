package com.example.travelapp.repository;

import com.example.travelapp.model.Account;
import com.example.travelapp.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    @Query(value = "select * from schedule where tour_id =?1 and day_start > CURDATE()", nativeQuery = true)
    public List<Schedule> getSchedule(Long id);
}
