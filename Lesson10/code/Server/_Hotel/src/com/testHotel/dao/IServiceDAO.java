package com.testHotel.dao;

import com.testHotel.entity.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IServiceDAO {
     void add(Service service) ;

     List<Service> getAllServices();
     Service getById(long id);

     void update(Service service);

     void remove(Service service);

     void setCon(Connection con);

}
