package com.damian.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class Item extends SuperEntity{
    @Id
    @NonNull
    private String itemCode;
    @NonNull
    private String description;
    @NonNull
    private double unitPrice;
    @NonNull
    private int qtyOnHand;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Order_Item",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "itemCode")
    )
    private List<Orders>ordersList;

}
