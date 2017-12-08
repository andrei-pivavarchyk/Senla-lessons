package com.testHotel.dao;


import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.service.GuestService;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO {

private Connection con= ConnectionUtil.getConnectionUtil().getConnection();


    public Logger log = Logger.getLogger(GuestService.class);

    public void add(Service service) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO service ( name, cost,type ) VALUES( ?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getCost());
            preparedStatement.setString(3, service.getType().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error(e.toString());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Service> getAllServices() {

        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id,name,cost,type FROM service";
        List<Service> allServices = new ArrayList<Service>();

        try {

            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                ServiceType serviceType = ServiceType.valueOf(resultSet.getString("type"));
                Service service = new Service(id, serviceType, name, cost);
                allServices.add(service);
            }
        } catch (SQLException e) {
            log.error(e.toString());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return allServices;
    }

    @Override
    public Service getById(long id) {
        return null;
    }

    @Override
    public void update(Service service) {

    }

    @Override
    public void remove(Service service) {

    }

    public void setCon(Connection con) {
        this.con = con;
    }
}