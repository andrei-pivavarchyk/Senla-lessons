

import org.hibernate.Session;


import java.sql.SQLException;

public class DAO {
    private Session session= HibernateUtil.getSessionFactory().openSession();


    public void addItem() throws SQLException, Exception {
        Video video = new Video();
        video.setId((long)3);
        video.setDescription("Калигула");
        Actor actor = new Actor();
        actor.setId(new Long(1));


        actor.setName("Телка из массовки звать Маня");
        Cast cast = new Cast();
        cast.setVideo(video);
        cast.setActor(actor);

        session.beginTransaction();
        session.saveOrUpdate(video);
        session.saveOrUpdate(actor);
        session.saveOrUpdate(cast);
        session.getTransaction().commit();
        session.close();
    }
}
