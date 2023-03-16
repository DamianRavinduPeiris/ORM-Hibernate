package com.damian.hibernate.dto;

import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.entity.Item;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor

public class Order_DTO {
    @Id
    @NonNull
    private String oId;
    @NonNull
    private Date date;
    @NonNull
    private Customer customer;

    private List<Item> itemsList;
}
