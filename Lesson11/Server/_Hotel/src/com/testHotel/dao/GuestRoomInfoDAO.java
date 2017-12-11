package com.testHotel.dao;

import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public class GuestRoomInfoDAO {
        /*extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO {


    @Override
    public String getSelectQuery() {
        return " SELECT id,arrivaldate,departuredate,guest,room,issteelliving FROM hotel.guestroominfo";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel.guestroominfo(arrivaldate,departuredate,guest,room,isstillliving) values(?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel.guestroominfo SET arrivaldate= ?, departuredate = ?,guest=?,room=?,isstillliving=? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel.guestroominfo WHERE id= ?;";
    }

    @Override
    protected List<GuestRoomInfo> parseResultSet(ResultSet rs) {
        List<GuestRoomInfo> result = new ArrayList<GuestRoomInfo>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String arrivalDate = rs.getString("arrivaldate");
                String departureDate = rs.getString("departuredate");
                int guest = rs.getInt("guest");
                int room = rs.getInt("room");
                int isstillliving = rs.getInt("isstillliving");
Boolean isliving=false;
if(isstillliving==1){isliving=true;}

               // GuestRoomInfo guestRoomInfo = new GuestRoomInfo(id, new Date(),new Date(),guest,room,isliving);
             //   result.add(service);
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
            statement.setInt(4,object.getId());
        } catch (Exception e) {
            log.equals(e.toString());
        }

    }
*/
}
