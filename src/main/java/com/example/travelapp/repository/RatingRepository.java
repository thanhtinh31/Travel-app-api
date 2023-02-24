package com.example.travelapp.repository;

import com.example.travelapp.model.Rating;
import com.example.travelapp.model.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
    @Query(value = "Select *  from rating where tour_id =?1", nativeQuery = true)
    List<Rating> getListRating(Long id);
}
