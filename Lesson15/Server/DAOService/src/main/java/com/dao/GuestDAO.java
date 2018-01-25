package com.dao;

import com.dao.api.IGuestDAO;
import com.entity.Guest;


public class GuestDAO extends BaseDAO<Guest> implements IGuestDAO {
    public GuestDAO() {
        super("Guest", Guest.class);
    }
}
