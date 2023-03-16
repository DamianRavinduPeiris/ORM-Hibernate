package com.damian.hibernate.service.custom;

import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.service.util.SuperService;

import java.util.List;

public interface ItemServiceDAO extends SuperService{
    boolean add(Item_DTO dto);
    boolean update(Item_DTO dto);
    boolean delete(String id);
    Item_DTO search(String id);
    List<Item_DTO>getAll();
}
