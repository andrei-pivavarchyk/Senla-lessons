import java.util.Date;

public class Main {

    public static void main(String[] args){


HibernateUtil.getSessionFactory();
DAO dao=new DAO();
Actor actor=new Actor();
actor.setName("dfsfds");
System.out.println(Actor.class.getName());

actor.setBirthday(new Date());
        try {
            dao.addItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
