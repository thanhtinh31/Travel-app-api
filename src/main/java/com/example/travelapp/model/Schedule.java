package com.example.travelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name ="schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String tourGuide;

    @Column
    private String phone;

    @Column
    private Date dayStart;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour_id;

    @OneToMany(mappedBy="schedule", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Invoice> listInvoice;
}
