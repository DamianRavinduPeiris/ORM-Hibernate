package com.damian.hibernate.dao.impl;

import com.damian.hibernate.dao.custom.ItemDAO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.repositories.ItemRepo;

import java.util.List;

public class ItemDAOimpl implements ItemDAO {
    @Override
    public boolean add(Item item) {
        ItemRepo itemRepo = new ItemRepo();
        return itemRepo.add(item);
    }

    @Override
    public Item search(String id) {
        ItemRepo itemRepo = new ItemRepo();
        return itemRepo.findById(id);
    }

    @Override
    public boolean update(Item item) {
        ItemRepo itemRepo = new ItemRepo();
        return itemRepo.update(item);
    }

    @Override
    public boolean delete(String id) {
        ItemRepo itemRepo = new ItemRepo();
        return itemRepo.delete(id);
    }

    @Override
    public List<Item> getAll() {
        ItemRepo repo = new ItemRepo();
        return repo.getAll();
    }
}
