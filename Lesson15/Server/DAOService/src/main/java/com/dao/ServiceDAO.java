package com.dao;


import com.entity.Service;


public class ServiceDAO extends BaseDAO<Service> implements IServiceDAO {

    public ServiceDAO() {
        super("Service", Service.class);
    }
}
