package com.dao;

import com.testHotel.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public class RoomDAO extends BaseDAO<Room> implements IRoomDAO{


    @Override
    public String getSelectQuery() {
        return " SELECT number,cost,capacity,stars FROM hotel4.room";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel4.room(number,cost,capacity,stars) values(?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel4.room SET number= ?, cost = ?, capacity = ?, stars = ? WHERE number= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel4.room WHERE number= ?;";
    }

    @Override
    protected List<Room> parseResultSet(ResultSet rs) {
        List<Room> result = new ArrayList<Room>();
        try {
            while (rs.next()) {
                int number = rs.getInt("number");
                int cost = rs.getInt("cost");
                int capacity = rs.getInt("capacity");
                int stars = rs.getInt("stars");
                Room room = new Room(number,number,cost,capacity,stars);
                result.add(room);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Room object) {

        try {
            statement.setInt(1, object.getNumber());
            statement.setInt(1, object.getNumber());
            statement.setInt(2, object.getCost());
            statement.setInt(3, object.getCapacity());
            statement.setInt(4, object.getStars());


        } catch (Exception e) {
            log.equals(e.toString());
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Room object) {
        try {
            statement.setInt(1,object.getNumber());
            statement.setInt(2,object.getCost());
            statement.setInt(3,object.getCapacity());
            statement.setInt(4,object.getStars());
            statement.setInt(5,object.getNumber());
        } catch (Exception e) {
            log.equals(e.toString());
        }
    }
}
