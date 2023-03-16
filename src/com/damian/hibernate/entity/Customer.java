package com.damian.hibernate.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@RequiredArgsConstructor


public class Customer extends SuperEntity{
    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private double salary;
    @OneToMany(mappedBy = "customer",targetEntity = Orders.class,cascade = CascadeType.ALL)
    private List <Orders> order;


}
