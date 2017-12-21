package bl; /**
 * Created by андрей on 21.12.2017.
 */
import org.hibernate.Session;


import java.sql.Date;
import java.sql.SQLException;
import java.util.*;


public class Domain {

    public static void main(String[] args) throws SQLException {

Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }

}