package com.dao;

import com.daoAPI.IAddressDAO;
import com.model.Address;
import org.springframework.stereotype.Repository;


@Repository
public class AddressDAO extends BaseDAO<Address> implements IAddressDAO {

    public AddressDAO(){
        super(Address.class);
    }
}
