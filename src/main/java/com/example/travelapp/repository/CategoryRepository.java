package com.example.travelapp.repository;

import com.example.travelapp.model.Account;
import com.example.travelapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "select * from category where status = 1", nativeQuery = true)
    List<Category> getCategoryActive();
}
