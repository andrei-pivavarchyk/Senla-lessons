package com.dao;

import com.daoAPI.IShopPhoneDAO;
import com.model.ShopPhone;
import org.springframework.stereotype.Repository;

@Repository
public class ShopPhoneDAO extends BaseDAO<ShopPhone> implements IShopPhoneDAO {
    public ShopPhoneDAO() {
        super(ShopPhone.class);
    }
}