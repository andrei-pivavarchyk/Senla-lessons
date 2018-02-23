package com.dao;

import com.daoAPI.IShopContactDAO;
import com.model.ShopContact;
import org.springframework.stereotype.Repository;

@Repository
public class ShopContactDAO extends BaseDAO<ShopContact> implements IShopContactDAO {

    public ShopContactDAO() {
        super(ShopContact.class);
    }
}