package com.testHotel.dao;

import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by андрей on 10.12.2017.
 */
public class ServiceGenericDao extends BaseDAO<Service, Integer> {


    @Override
    public String getSelectQuery() {
        return " SELECT id,name,cost,type FROM service;";
    }

    @Override
    public String getCreateQuery() {
        return "insert into service(name,cost,type) values(?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.Group SET number= ?, department = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.Group WHERE id= ?;";
    }

    @Override
    protected List<Service> parseResultSet(ResultSet rs) {
        List<Service> result = new ArrayList<Service>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                ServiceType type = ServiceType.valueOf(rs.getString("type"));
                Service service = new Service(id, type, name, cost);
                result.add(service);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;


    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Service object) {

        try {

            statement.setString(1, object.getName());
            statement.setInt(2, object.getCost());
            statement.setString(3, object.getType().toString());
        } catch (Exception e) {
            log.equals(e.toString());
        }

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Service object) {

    }


}
