package com.bl;

import com.entity.ServiceEntity;
import org.hibernate.Session;
import java.sql.SQLException;



public class Domain {

    public static void main(String[] args) throws SQLException {

        ServiceEntity serviceEntity=new ServiceEntity();
        serviceEntity.setCost(2);
        serviceEntity.setId(1);
        serviceEntity.setName("dfds");
        serviceEntity.setType("sd");
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(serviceEntity);
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }

}