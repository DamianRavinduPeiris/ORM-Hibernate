package com.damian.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetail extends SuperEntity{
    private String orderId;

    private String itemCode;

    private int qty;

    private double unitPrice;


}
