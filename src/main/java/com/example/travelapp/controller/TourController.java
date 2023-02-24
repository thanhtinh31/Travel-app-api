package com.example.travelapp.controller;

import com.example.travelapp.request.SearchTourRequest;
import com.example.travelapp.model.TourEntity;
import com.example.travelapp.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tour")
@CrossOrigin
public class TourController {
    @Autowired
    TourService tourService;
    @GetMapping
    public ResponseEntity<?> getListTour(){
        List<TourEntity> tours=tourService.getAllTour() ;
        return ResponseEntity.ok(tours);
    }
    @GetMapping("/active")
    public ResponseEntity<?> getTourActive(){
        List<TourEntity> tour= tourService.getTourActive();
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    @GetMapping("/sale")
    public ResponseEntity<?> getTourSale(){
        List<TourEntity> tour= tourService.getTourSale();
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTour(@PathVariable Long id){
        TourEntity tour= tourService.getTour(id);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    @GetMapping("getmytour/{id}")
    public ResponseEntity<?> getMyTour(@PathVariable Long id){
        List<TourEntity> tours= tourService.getTourByUserId(id);
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> add( @RequestBody TourEntity tour){
        return new ResponseEntity<>(tourService.saveTour(tour), HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchTour(@RequestBody SearchTourRequest key){
        return new ResponseEntity<>(tourService.searchByTitle(key.getKey()),HttpStatus.OK);
    }
    @PutMapping(path = "update/{id}")
    public Map<String,Object> update(@RequestBody TourEntity tourEntity, @PathVariable Long id){
        return tourService.updateTour(id,tourEntity);
    }
    @DeleteMapping("/{id}")
    public Map<String,Object> delete(@PathVariable Long id)
    {
        return  tourService.deleteTour(id);
    }
}
