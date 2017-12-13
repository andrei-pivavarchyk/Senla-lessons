package com.dao;

import com.testHotel.entity.Guest;


public interface IGuestDAO extends IBaseDAO<Guest> {
    Integer  getCountEntity();
}
