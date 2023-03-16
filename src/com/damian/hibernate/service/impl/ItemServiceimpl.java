package com.damian.hibernate.service.impl;

import com.damian.hibernate.convertor.Convertor;
import com.damian.hibernate.dao.impl.ItemDAOimpl;
import com.damian.hibernate.dao.util.DAOFactory;
import com.damian.hibernate.dao.util.DAOTypes;
import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.service.custom.ItemServiceDAO;

import java.util.List;

public class ItemServiceimpl implements ItemServiceDAO {
    @Override
    public boolean add(Item_DTO item) {
        ItemDAOimpl dao = (ItemDAOimpl) DAOFactory.getDAO(DAOTypes.ITEM);
        return dao.add(Convertor.convertItemDTOToEntity(item));
    }

    @Override
    public boolean update(Item_DTO item) {
        ItemDAOimpl dao = (ItemDAOimpl) DAOFactory.getDAO(DAOTypes.ITEM);
        return dao.update(Convertor.convertItemDTOToEntity(item));
    }

    @Override
    public boolean delete(String id) {
        ItemDAOimpl dao = (ItemDAOimpl) DAOFactory.getDAO(DAOTypes.ITEM);
        return dao.delete(id);
    }

    @Override
    public Item_DTO search(String id) {
        ItemDAOimpl dao = (ItemDAOimpl) DAOFactory.getDAO(DAOTypes.ITEM);
        Item item = dao.search(id);
        return item == null ? null : Convertor.convertItemEntityToDTO(item);
    }

    @Override
    public List<Item_DTO> getAll() {
        ItemDAOimpl dao = (ItemDAOimpl) DAOFactory.getDAO(DAOTypes.ITEM);
        return Convertor.toItemDTOList(dao.getAll());
    }
}
