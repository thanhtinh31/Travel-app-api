package com.example.travelapp.repository;

import com.example.travelapp.model.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourReponsitory extends JpaRepository<TourEntity,Long> {

    @Query(value = "Select * from tour where status <> 0 and slot >0 ", nativeQuery = true)
    List<TourEntity> getTourActive();
    @Query(value = "Select * from tour where id= ?1", nativeQuery = true)
    TourEntity getTour(Long id);

    @Query(value = "Select *  from tour where status <>0 and slot>0 ORDER BY sale DESC limit 6", nativeQuery = true)
    List<TourEntity> getTourSale();

    @Query(value = "Select *  from tour where id_seller =?1", nativeQuery = true)
    List<TourEntity> getTourByIdUser(Long id);

    @Query(value = "Select * from tour where title like %?1% or address like %?1% or sub_title like %?1% having status <>0 and slot >0", nativeQuery = true)
    List<TourEntity> searchByTitle(String key);
}
