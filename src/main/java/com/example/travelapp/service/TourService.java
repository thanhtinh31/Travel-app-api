package com.example.travelapp.service;

import com.example.travelapp.model.Account;
import com.example.travelapp.model.TourEntity;
import com.example.travelapp.repository.TourReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TourService {
    @Autowired
    private TourReponsitory tourReponsitory;
    public List<TourEntity> getAllTour(){
        return tourReponsitory.findAll();
    }
    public TourEntity saveTour(TourEntity tour){return tourReponsitory.save(tour);
    }
    public TourEntity getTour(Long id){
        return tourReponsitory.getTour(id);
    }
    public void delete(Long id){
        tourReponsitory.deleteById(id);
    }
    public List<TourEntity> searchByTitle(String key){
        return tourReponsitory.searchByTitle(key);
    }
    public List<TourEntity> getTourActive(){
        return tourReponsitory.getTourActive();
    }
    public List<TourEntity> getTourSale(){
        return tourReponsitory.getTourSale();
    }
    public List<TourEntity> getTourByUserId(Long id){
        return tourReponsitory.getTourByIdUser(id);
    }

    public Map<String,Object> deleteTour(Long id){
        Map<String,Object> m=new HashMap<>();
        try {
            tourReponsitory.deleteById(id);
            m.put("status","1");
            m.put("message","Xoa thanh cong");
        }catch (Exception e){
            m.put("status","0");
            m.put("message","Xoa khong thanh cong");
        }
        return m;
    }
    public Map<String,Object> updateTour(Long id, TourEntity tourEntity){
        Map<String,Object> m=new HashMap<>();
            TourEntity tourEntity1 = tourReponsitory.findById(id).get();
            if(tourEntity1!=null) {
                tourEntity1.setCategory(tourEntity.getCategory());
                tourEntity1.setAddress(tourEntity.getAddress());
                tourEntity1.setImage(tourEntity.getImage());
                tourEntity1.setStatus(tourEntity.getStatus());
                tourEntity1.setDescribe(tourEntity.getDescribe());
                tourEntity1.setTitle(tourEntity.getTitle());
                tourEntity1.setSubTitle(tourEntity.getSubTitle());
                tourEntity1.setVehicle(tourEntity.getVehicle());
                tourEntity1.setSale(tourEntity.getSale());
                tourEntity1.setPrice(tourEntity.getPrice());

                tourEntity1.setInteval(tourEntity.getInteval());
                tourEntity1.setInteresting(tourEntity.getInteresting());

                tourEntity1.setStatus(tourEntity.getStatus());

                tourReponsitory.save(tourEntity1);
                m.put("status", "1");
                m.put("message", "cap nhat thanh cong");
                m.put("tour", tourEntity1);
            }

        return m;
    }

}
