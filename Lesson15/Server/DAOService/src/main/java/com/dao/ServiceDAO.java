package com.dao;


import com.dao.api.IServiceDAO;
import com.entity.Service;


public class ServiceDAO extends BaseDAO<Service> implements IServiceDAO {

    public ServiceDAO() {
        super("Service", Service.class);
    }
}
