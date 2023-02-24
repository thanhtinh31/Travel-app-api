package com.example.travelapp.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class categoryrequest {
    private Long id;
    private String name;
    private String content;
    private String image;
    private boolean status;
    private List<String> tour;
}
