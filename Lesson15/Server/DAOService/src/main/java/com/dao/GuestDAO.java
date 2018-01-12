package com.dao;

import com.entity.Guest;


public class GuestDAO extends BaseDAO<Guest> implements IGuestDAO{
public GuestDAO(){
    super("Guest");
}
   }
