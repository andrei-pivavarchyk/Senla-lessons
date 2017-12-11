package com.testHotel.dao;

import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.entity.Room;
import com.testHotel.entity.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestServiceDAO extends BaseDAO<GuestServiceInfo> implements IGuestServiceDAO  {
    private IServiceDAO serviceDAO=(IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    private IGuestDAO guestDAO=(IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);

    @Override
    public String getSelectQuery() {
        return " SELECT guest,service,date FROM hotel4.guestserviceinfo";
    }

    @Override
    public String getCreateQuery() {
        return "insert into hotel4.guestserviceinfo(guest,service,date) values(?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE hotel4.guestserviceinfo SET  service = ?, date = ? WHERE guest= ? and service =?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE  FROM hotel4.guestserviceinfo WHERE id= ? ";
    }


    public String getAllGuestServicesQuery() {
        return " SELECT guest,service,date FROM hotel4.guestserviceinfo WHERE guest= ? ;";
    }


    @Override
    protected List<GuestServiceInfo> parseResultSet(ResultSet rs) {
        List<GuestServiceInfo> result = new ArrayList<GuestServiceInfo>();
        try {
            while (rs.next()) {
                int guestID = rs.getInt("guest");
                int serviceID = rs.getInt("service");
                int date = rs.getInt("date");
                Timestamp timestamp=new Timestamp(date);
                Guest guest=this.guestDAO.getEntity(guestID);
                Service service=this.serviceDAO.getEntity(serviceID);
               GuestServiceInfo guestServiceInfo=new GuestServiceInfo(1,guest,service,new Date(timestamp.getTime()));
                result.add(guestServiceInfo);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, GuestServiceInfo object) {

        try {
            Timestamp date=new Timestamp(object.getDate().getTime());
            statement.setInt(1, object.getGuest().getId());
            statement.setInt(2, object.getService().getId());
            statement.setTimestamp(3, date);

        } catch (Exception e) {
            log.equals(e.toString());
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, GuestServiceInfo object) {
      /*  try {
            statement.setInt(1,object.getNumber());
            statement.setInt(2,object.getCost());
            statement.setInt(3,object.getCapacity());
            statement.setInt(4,object.getStars());
            statement.setInt(5,object.getNumber());
        } catch (Exception e) {
            log.equals(e.toString());
        }
     */}

}
