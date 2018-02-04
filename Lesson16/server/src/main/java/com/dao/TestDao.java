package com.dao;

import org.hibernate.SessionFactory;

public class TestDao {
    private SessionFactory sessionFactory;

    public TestDao(SessionFactory sessionFactory){
      this.sessionFactory=sessionFactory;
    }
}
