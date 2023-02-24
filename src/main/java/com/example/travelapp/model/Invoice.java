package com.example.travelapp.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateInvoice;
    private int status;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String note;
    private String payments;
    private String bankTranNo;
    private String payDay;
    private String Bank;
    private int people;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account accountInvoice;

}
