package com.example.travelapp.controller;

import com.example.travelapp.model.Account;
import com.example.travelapp.model.Schedule;
import com.example.travelapp.service.AccountService;
import com.example.travelapp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> getListScheduleById(@PathVariable Long id){
        List<Schedule> schedule= service.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }
}
