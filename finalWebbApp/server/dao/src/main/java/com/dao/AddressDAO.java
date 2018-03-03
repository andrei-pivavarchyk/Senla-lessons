package com.dao;

import com.daoAPI.IAddressDAO;
import com.model.Address;
import com.model.UserData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;


@Repository
public class AddressDAO extends BaseDAO<Address> implements IAddressDAO {

    public AddressDAO(){
        super(Address.class);
    }

}
