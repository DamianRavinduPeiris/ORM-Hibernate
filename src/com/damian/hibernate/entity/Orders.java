package com.damian.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders extends SuperEntity{
    @Id
    private String oId;

    private Date date;

    @ManyToOne

    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item>itemList;
}
