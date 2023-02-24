package com.example.travelapp.service;

import com.example.travelapp.model.Schedule;
import com.example.travelapp.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    public List<Schedule> getScheduleById(Long id){
        return scheduleRepository.getSchedule(id);
    }
}
