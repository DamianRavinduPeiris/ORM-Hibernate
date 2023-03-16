package com.damian.hibernate.dao.util;

import com.damian.hibernate.entity.SuperEntity;

import java.util.List;

public interface SuperDAO <T extends SuperEntity>{
    boolean add(T t);
    T search(String id);
    boolean update(T t);
    boolean delete(String id);

    List<T> getAll();
}
