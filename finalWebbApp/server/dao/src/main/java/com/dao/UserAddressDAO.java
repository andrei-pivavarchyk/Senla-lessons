package com.dao;

import com.daoAPI.IAddressDAO;
import com.model.Address;
import org.springframework.stereotype.Repository;


@Repository
public class UserAddressDAO extends BaseDAO<Address> implements IAddressDAO {

    public UserAddressDAO(){
        super(Address.class);
    }
}
