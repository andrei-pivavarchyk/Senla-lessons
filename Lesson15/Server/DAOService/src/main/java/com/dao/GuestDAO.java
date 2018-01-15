package com.dao;

import com.entity.Guest;
import org.apache.log4j.Logger;


public class GuestDAO extends BaseDAO<Guest> implements IGuestDAO {
    public GuestDAO() {
        super("Guest", Guest.class);
    }
}
