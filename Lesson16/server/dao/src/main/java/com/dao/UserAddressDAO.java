package com.dao;

import com.daoAPI.IUserAddressDAO;
import com.model.UserAddress;
import org.springframework.stereotype.Repository;


@Repository
public class UserAddressDAO extends BaseDAO<UserAddress> implements IUserAddressDAO {

    public UserAddressDAO(){
        super(UserAddress.class);
    }
}
