package com.example.travelapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Autowired
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date time;
    private int star;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountRating;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;


}
