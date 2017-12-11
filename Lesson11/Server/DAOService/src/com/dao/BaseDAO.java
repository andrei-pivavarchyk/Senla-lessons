package com.dao;

import com.testHotel.entity.Entity;
import com.testHotel.service.GuestService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T extends Entity> implements IBaseDAO<T>{

    public Logger log = Logger.getLogger(GuestService.class);
    private Connection con = ConnectionUtil.getConnectionUtil().getConnection();

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs);

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    public Connection getCon() {
        return con;
    }

    public List<T> getAllEntities() {
        List<T> list = new ArrayList<T>();
        String sql = getSelectQuery();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return list;
    }


    public void addEntity(T object) {
        T persistInstance = null;
        String sql = getCreateQuery();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            statement.executeUpdate();

        } catch (Exception e) {

            log.error(e.toString());
        }
    }

    public void removeEntity(T object) {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            try {
                statement.setInt(1, object.getId());
            } catch (Exception e) {
                log.error(e.toString());
            }
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public T getEntity(int id) {
        List<T> list = new ArrayList<T>();
        String sql = getSelectQuery();
        sql += " WHERE id = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {

            log.error(e.toString());
        }
        return list.iterator().next();
    }

    public void updateEntity(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();

        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}


