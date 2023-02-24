package com.example.travelapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name ="account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name_account", unique = true)
    private String nameAccount;

    @Column(name= "password")
    private String password;

    @Column(name= "full_name")
    private String fullName;

    @Column(name= "email")
    private String email;


    @Column(name= "image")
    private String image;

    private String phoneNumber;

    private String address;

    @Column(name= "status")
    private boolean status;

    @Column(name= "type_account")
    private int typeAccount=1;

    @OneToMany(mappedBy="accountTour", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TourEntity> listTour;


    @OneToMany(mappedBy="accountInvoice", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Invoice> listInvoice;

    @OneToMany(mappedBy="accountRating", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> listRating;


}
