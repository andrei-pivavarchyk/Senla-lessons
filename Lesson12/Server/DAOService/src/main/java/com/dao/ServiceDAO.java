package com.dao;


import com.entity.Service;
import com.entity.ServiceType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by андрей on 10.12.2017.
 */
public class ServiceDAO extends BaseDAO<Service> implements IServiceDAO {
    public ServiceDAO(){
        super.primaryKey="id";
    }
    @Override
    public String getSelectQuery() {
        return " SELECT id,name,cost,type FROM hotel4.service";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel4.service(name,cost,type) values(?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel4.service SET name= ?, cost = ?,type=? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel4.service WHERE id= ?;";
    }


    public String getCountQuery() {
        return "select count(id) from hotel4.service;";
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
                Service service = new Service( type, name, cost);
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
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getCost());
            statement.setString(3, object.getType().toString());
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            log.equals(e.toString());
        }
    }




}
