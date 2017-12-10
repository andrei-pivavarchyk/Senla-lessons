package com.testHotel.dao;

import com.testHotel.entity.Entity;
import com.testHotel.service.GuestService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T extends Entity, PK extends Integer> {

    public Logger log = Logger.getLogger(GuestService.class);
    private Connection con = ConnectionUtil.getConnectionUtil().getConnection();


    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для вставки новой записи в базу данных.
     * <p/>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для удаления записи из базы данных.
     * <p/>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs);

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    public Connection getCon() {
        return con;
    }


    public List<T> getAll() {
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


    public void persist(T object) {

        T persistInstance = null;
        // Добавляем запись
        String sql = getCreateQuery();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {

            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

}
