


import com.model.*;
import com.service.TokenHandler;
import com.serviceAPI.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar();
        calendar.set(1992, 11, 4);
        Date date = new Date(calendar.getTime().getTime());


        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        IUserService userService = context.getBean(IUserService.class);
        IUserDataService userDataService = context.getBean(IUserDataService.class);

        IUserHandler г = context.getBean(IUserHandler.class);
        ITokenHandler tokenHandler = context.getBean(ITokenHandler.class);
        Role role = Role.ADMIN;


        User user = new User(new Long(1), "Andrei", "Hrumov");
      //  UserAddress userAddress = new UserAddress(new Long(1), "Соломовой", "Гродно", "Гродненский", "Беоарусь", 240000);
      //  UserContact userContact = new UserContact(new Long(1),"andreyatake666@mail.ru",2816940);
      //  UserData userData = new UserData(user, "Bob", "White", "Black", calendar.getTime(), "email", role, userAddress,userContact);

      userService.addUser(user);

        // userDataService.getUserDataByUserId(new Long(1));
        //System.out.print(userDataService.getUserDataByUserId(new Long(1)).getName());
        //  UserData userData=new UserData(user,"Fds","fds","fd",new Date());
        // userService.addUser(user);
        //  userDataService.addUserData(userData);
    }
}