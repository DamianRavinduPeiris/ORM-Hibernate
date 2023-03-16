package com.damian.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetail_DTO {

    private String orderId;

    private String itemCode;
    private int qty;
    private double unitPrice;

}
