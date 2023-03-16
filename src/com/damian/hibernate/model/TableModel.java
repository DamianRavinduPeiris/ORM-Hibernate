package com.damian.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableModel {
    private String oID;
    private String description;
    private double unitPrice;
    private int qty;
    private String itemCode;

}
