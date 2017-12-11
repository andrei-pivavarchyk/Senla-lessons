package com.testHotel.dao;

import com.dependencyService.DependencyService;
import com.testHotel.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by андрей on 11.12.2017.
 */
public class GuestRoomInfoDAO extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO {
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);

    @Override
    public String getSelectQuery() {
        return " SELECT id,arrivaldate,departuredate,guest,room,isstillliving FROM hotel4.guestroominfo";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel4.guestroominfo(arrivaldate,departuredate,guest,room,isstillliving) values(?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel4.guestroominfo SET arrivaldate= ?, departuredate = ?,guest=?,room=?,isstillliving=? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel4.guestroominfo WHERE id= ?;";
    }

    @Override
    protected List<GuestRoomInfo> parseResultSet(ResultSet rs) {
        List<GuestRoomInfo> result = new ArrayList<GuestRoomInfo>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                long arrivalDate = rs.getLong("arrivaldate");
                long departureDate = rs.getLong("departuredate");
                int guest = rs.getInt("guest");
                int room = rs.getInt("room");
                int isLivingNumber = rs.getInt("isstillliving");
                Boolean isStillLiving = false;
                if (isLivingNumber == 1) {
                    isStillLiving = true;
                }
Date arrival= new Date(new Timestamp(arrivalDate).getTime()) ;
Date departure= new Date(new Timestamp(departureDate).getTime()) ;
                GregorianCalendar gregorianCalendar=new GregorianCalendar();
                gregorianCalendar.setTime(departure);
               int year =gregorianCalendar.get(Calendar.YEAR);
               int month =gregorianCalendar.get(Calendar.MONTH);
               int day =gregorianCalendar.get(Calendar.DAY_OF_MONTH);
Guest guest1=guestDAO.getEntity(guest);
Room room1=roomDAO.getEntity(room);

                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(id, arrival,guest1,room1,year,month,day);
                   result.add(guestRoomInfo);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;


    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, GuestRoomInfo object) {
        Timestamp arrival=new Timestamp(object.getArrivalDate().getTime());
        Timestamp departure=new Timestamp(object.getDepartureDate().getTime());
        int stillLiving=1;
        if(object.getStillLiving().equals(false)){
            stillLiving=0;
        }

        try {

            statement.setTimestamp(1,arrival );
            statement.setTimestamp(2,departure );
            statement.setInt(3, object.getGuest().getId());
            statement.setInt(4, object.getRoom().getId());
            statement.setInt(5,stillLiving);
        } catch (Exception e) {
            log.equals(e.toString());
        }

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, GuestRoomInfo object) {
      /*  try {

            statement.setString(1, object.getName());
            statement.setInt(2, object.getCost());
            statement.setString(3, object.getType().toString());
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            log.equals(e.toString());
        }
*/
    }

}
