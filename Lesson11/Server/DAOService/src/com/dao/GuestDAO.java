package com.dao;

import com.testHotel.entity.Guest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GuestDAO extends BaseDAO<Guest> implements IGuestDAO {


    @Override
    public String getSelectQuery() {
        return " SELECT id,name,surname FROM hotel4.guest";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel4.guest(name,surname) values(?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel4.guest SET name= ?, surname = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel4.guest WHERE id= ?;";
    }
    @Override
    public String getCountQuery() {
        return "select count(id) from hotel4.guest;";
    }
    @Override
    protected List<Guest> parseResultSet(ResultSet rs) {
        List<Guest> result = new ArrayList<Guest>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Guest guest = new Guest(id,name,surname);
                result.add(guest);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Guest object) {
        try {
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurName());
        } catch (Exception e) {
            log.equals(e.toString());
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Guest object) {
        try {
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurName());
            statement.setInt(3,object.getId());
        } catch (Exception e) {
            log.equals(e.toString());
        }
    }
}
