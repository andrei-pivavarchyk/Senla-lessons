package com.dao;

import com.daoAPI.IShopDataDAO;
import com.model.ShopData;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDataDAO extends BaseDAO<ShopData> implements IShopDataDAO {

    public ShopDataDAO() {
        super(ShopData.class);
    }
}