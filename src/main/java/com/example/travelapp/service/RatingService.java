package com.example.travelapp.service;

import com.example.travelapp.model.Rating;
import com.example.travelapp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;
    public List<Rating> getAll(){
        return ratingRepository.findAll();
    }
    public List<Rating> getListRatingTour(Long id_tour){
        return ratingRepository.getListRating(id_tour);
    }
    public Rating create(Rating rating)
    {
        Date date = new Date();
        if (rating != null) {
            rating.setTime(date);
        }
        return ratingRepository.save(rating);
    }

}
