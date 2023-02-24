package com.example.travelapp.controller;

import com.example.travelapp.model.Rating;
import com.example.travelapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@CrossOrigin
public class RatingController {
    @Autowired
    RatingService ratingService;
    @GetMapping
    public ResponseEntity<?> getListRating(){
        List<Rating> ratings= ratingService.getAll();
        return ResponseEntity.ok(ratings);
    }
    @GetMapping("/ratingtour/{id}")
    public ResponseEntity<?> getListRatingTour(@PathVariable Long id){
        List<Rating> ratings= ratingService.getListRatingTour(id);
        return ResponseEntity.ok(ratings);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
        return ResponseEntity.ok(ratingService.create(rating));
    }
}
