package com.damian.hibernate.dto;

import com.damian.hibernate.entity.Orders;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor

public class Item_DTO {
    @NonNull
    private String itemCode;
    @NonNull
    private String description;
    @NonNull
    private double unitPrice;
    @NonNull
    private int qtyOnHand;

    private List<Orders> ordersList;

}
