package com.dao;


import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class GuestRoomInfoDAO extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO {
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);

    public GuestRoomInfoDAO() {
        super.primaryKey = "id";
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
    public String getStatusUpdateQuery() {
        return "UPDATE hotel4.guestroominfo SET isstillliving=? WHERE guest= ?;";
    }
    @Override
    public String getDeleteQuery() {
        return "DELETE FROM hotel4.guestroominfo WHERE id= ?";
    }

    public String getDeleteQueryByGuestId() {
        return "DELETE FROM hotel4.guestroominfo WHERE guest= ?";
    }


    public String getCountGuestQuery() {
        return "select count(guest) from guestroominfo WHERE isstillliving=?";
    }

    public String getGuestsByStatus() {
        return "SELECT guest.id , guest.name,guest.surname FROM hotel4.guest\n" +
                "INNER JOIN hotel4.guestroominfo  ON hotel4.guest.id = hotel4.guestroominfo.guest and isstillliving=? ";
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
            GuestRoomInfo guestRoomInfo = this.parseResultSet(rs).get(0);
            return guestRoomInfo;
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving,TypeSorting sorting) {
        List<GuestRoomInfo> list = new ArrayList<GuestRoomInfo>();
        String sql = getSelectQuery();
        sql = sql + "WHERE isstillliving=?";
        if(sorting!=TypeSorting.NO_SORTING){
            sql=sql+" ORDER BY " +sorting.getType()+";";

        }
        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            if (isLiving.equals(true)) {
                statement.setInt(1, 1);
            } else {
                statement.setInt(1, 0);
            }
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return list;
    }

    public void removeEntityByGuestId(int guestID) {
        String sql = getDeleteQueryByGuestId();
        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            statement.setInt(1, guestID);
            statement.executeUpdate();
        } catch (Exception e) {
            log.error(e.toString());
            System.out.println(e.toString());
        }
    }



    public void updateEntityStatus(Guest guest,int status) {
        String sql = getStatusUpdateQuery();
        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            statement.setInt(status,guest.getId());
            int count = statement.executeUpdate();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public Integer  getCountGuests(Boolean isliving){
        int isliv=1;
        if(isliving.equals(false)){
            isliv=0;
        }
        String sql = getCountGuestQuery();
        int count=0;
        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            statement.setInt(1,isliv);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                count=rs.getInt("count(guest)");
            }

        } catch (Exception e) {
            log.error(e.toString());
        }
        return count;
    }

    public List<Guest> getGuestsByStatus(int status,int roomNumber,TypeSorting sorting) {
        List<Guest> list = new ArrayList<Guest>();
        String sql = getGuestsByStatus();

        if(roomNumber!=0){
            sql=sql+" and room=? ";
        }
        if(sorting!=TypeSorting.NO_SORTING){
            sql=sql+" ORDER BY " +sorting.getType();

        }

        try (PreparedStatement statement = super.getCon().prepareStatement(sql)) {
            statement.setInt(1,status);

            if(roomNumber!=0){
                statement.setInt(2,roomNumber);
            }
           ResultSet rs= statement.executeQuery();
            List<Guest> result = new ArrayList<Guest>();
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
    return null;
    }
}
