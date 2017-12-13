package com.dao;


import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

public class GuestRoomInfoDAO extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO {
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    public GuestRoomInfoDAO(){
        super.primaryKey="id";
    }
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
    public String getCountQuery() {
        return "select count(id) from guest;";
    }



    @Override
    protected List<GuestRoomInfo> parseResultSet(ResultSet rs) {
        List<GuestRoomInfo> result = new ArrayList<GuestRoomInfo>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                Timestamp arrivalDate = rs.getTimestamp("arrivaldate");
                Timestamp departureDate = rs.getTimestamp("departuredate");
                int guestId = rs.getInt("guest");
                int roomId = rs.getInt("room");
                int isLivingNumber = rs.getInt("isstillliving");
                Boolean isStillLiving = false;
                if (isLivingNumber == 1) {
                    isStillLiving = true;
                }
                Date arrival = new Date(arrivalDate.getTime());
                Date departure = new Date(departureDate.getTime());
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(departure);
                int year = gregorianCalendar.get(Calendar.YEAR);
                int month = gregorianCalendar.get(Calendar.MONTH);
                int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);

                Guest guest = guestDAO.getEntity(guestId);
                Room room = roomDAO.getEntity(roomId);

                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(id, arrival, guest, room, year, month, day);

                result.add(guestRoomInfo);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, GuestRoomInfo object) {
        Timestamp arrival = new Timestamp(object.getArrivalDate().getTime());
        Timestamp departure = new Timestamp(object.getDepartureDate().getTime());
        int stillLiving = 1;
        if (object.getStillLiving().equals(false)) {
            stillLiving = 0;
        }
        try {
            statement.setTimestamp(1, arrival);
            statement.setTimestamp(2, departure);
            statement.setInt(3, object.getGuest().getId());
            statement.setInt(4, object.getRoom().getId());
            statement.setInt(5, stillLiving);
        } catch (Exception e) {
            log.equals(e.toString());
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, GuestRoomInfo object) {
        Timestamp arrival = new Timestamp(object.getArrivalDate().getTime());
        Timestamp departure = new Timestamp(object.getDepartureDate().getTime());
        int stillLiving = 1;
        if (object.getStillLiving().equals(false)) {
            stillLiving = 0;
        }
        try {

            statement.setTimestamp(1, arrival);
            statement.setTimestamp(2, departure);
            statement.setInt(3, object.getGuest().getId());
            statement.setInt(4, object.getRoom().getId());
            statement.setInt(5, stillLiving);
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            log.equals(e.toString());
        }

    }

    public GuestRoomInfo getEntityByGuestId(int guestID) {
        String sql = getSelectQuery();
        sql += " WHERE guest = ?";
        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            statement.setInt(1, guestID);
            ResultSet rs = statement.executeQuery();
            GuestRoomInfo guestRoomInfo=this.parseResultSet(rs).get(0);
            return guestRoomInfo;
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }
public List<GuestRoomInfo> getCurrentGuestRoomInfo(){
    List<GuestRoomInfo> list = new ArrayList<GuestRoomInfo>();
    String sql = getSelectQuery();
    sql=sql+"WHERE isstillliving=?";
    try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
        statement.setInt(1, 1);
        ResultSet rs = statement.executeQuery();
        list = parseResultSet(rs);
    } catch (Exception e) {
        log.error(e.toString());
    }
    return list;
}


}
