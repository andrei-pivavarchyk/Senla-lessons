package com.dao;

import com.entity.Guest;
import org.hibernate.Query;

import java.util.List;

public class GuestDAO extends BaseDAO<Guest> implements IGuestDAO{
public GuestDAO(){
    super("Guest");
}
   }
