


import com.model.*;
import com.serviceAPI.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar();
        calendar.set(1992, 11, 4);
        Date date = new Date(calendar.getTime().getTime());

        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/root-context.xml");
        IUserService userService = context.getBean(IUserService.class);
        IUserDataService userDataService = context.getBean(IUserDataService.class);
        IUserHandler г = context.getBean(IUserHandler.class);
        ITokenHandler tokenHandler = context.getBean(ITokenHandler.class);
        IBookService bookService = context.getBean(IBookService.class);
        IAuthorService authorService = context.getBean(IAuthorService.class);
        IAddressService addressService=context.getBean(IAddressService.class);
        IUserDataDTOService userDataDTOService=context.getBean(IUserDataDTOService.class);
        Role role = Role.USER;
        Author author = new Author();



        User user = new User(1, "Andrei", "Hrumov");
        Book book = new Book(1, "bookname", 66, BookGenre.DETECTIVE, author, BookStatus.IN_STOCK, "Fds");
        Address userAddress = new Address(1, "Соломовой", "Гродно", "Гродненский", "Беоарусь", 240000);



        UserData userData = new UserData(1,user, "Bob", "White", "Black", role, "email", 21474836647L, userAddress);
       // userData.getFavorites().add(book);
        //userService.addUser(user);
        //userData.setAddress(userAddress);
       //userDataService.updateUserData(userData);
       // addressService.updateAddress(userAddress);
        //UserData userData1=userDataService.getFavorites(1);
       // System.out.print(userDataDTOService.getFavoriteBookList(userData1.getFavorites()).get(0).getBookCost());
       // userService.addUser(user);

        //  userData.getFavorites().add(book);
        // userService.addUser(user);
        //  userDataService.updateUserData();
        // userDataService.getUserDataByUserId(new Long(1));
        //System.out.print(userDataService.getUserDataByUserId(new Long(1)).getName());
        //  UserData userData=new UserData(user,"Fds","fds","fd",new Date());
        // userService.addUser(user);
        //  userDataService.addUserData(userData);
    }
}