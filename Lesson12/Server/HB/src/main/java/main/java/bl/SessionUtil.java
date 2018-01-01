package main.java.bl;

/**
 * Created by vserdiuk on 2/12/17.
 */
public class SessionUtil {

    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession() {
        return bl.HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransactionSesstion() {
        transaction.commit();
        closeSession();
    }
}
