package com.example.travelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "tour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "image")
    private String image;
    @Column(name = "mota")
    private String describe;
    @Column(name = "interesting")
    private String interesting;
    @Column(name = "address")
    private String address;
    @Column(name = "inteval")
    private String inteval;
    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "price")
    private Double price;

    @Column(name = "sell")
    private Double sale;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account accountTour;


    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    @OneToMany(mappedBy="tour", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> listRating;

    @OneToMany(mappedBy="tour_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Schedule> listSchedule;

}
