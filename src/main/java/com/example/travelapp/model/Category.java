package com.example.travelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name ="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String content;
    @Column
    private String image;
    @Column
    private boolean status;


    @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TourEntity> listTour;
}
