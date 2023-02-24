package com.example.travelapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassRequest {
    Long id;
    String oldPass;
    String newPass;
}
