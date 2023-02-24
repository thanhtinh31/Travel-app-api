package com.example.travelapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tax")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tax {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rate_tax")
    private Double rateTax;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="date_start")
    private Date dateStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="date_end")
    private Date dateEnd;

    @Column(name= "status")
    private boolean status;
}
