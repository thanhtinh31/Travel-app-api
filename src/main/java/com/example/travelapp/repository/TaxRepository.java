package com.example.travelapp.repository;

import com.example.travelapp.model.Account;
import com.example.travelapp.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Long> {
    @Query(value = "select * from tax where id = ?1", nativeQuery = true)
    Tax getTaxById(Long id);
    @Query(value = "select * from tax where name = ?1", nativeQuery = true)
    Tax getTaxByName(String name);
    @Query(value = "select status from tax where id = ?1", nativeQuery = true)
    boolean getStatus(Long id);
//    @Query(value = "Delete * from tax where id = ?1", nativeQuery = true)
//    void deleteById(Long id);

}
