package com.damian.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Customer_DTO {

    private String id;
    private String name;
    private String address;
    private double salary;
}
