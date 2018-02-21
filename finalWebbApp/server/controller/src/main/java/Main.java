


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
        IBookService bookService = context.getBean(IBookService.class);
        IAuthorService authorService = context.getBean(IAuthorService.class);
        Role role = Role.USER;
        Author author = new Author();

        User user = new User(new Long(1), "Andrei", "Hrumov");

        Book book = new Book(new Long(1), "bookname", 66, BookGenre.DETECTIVE, author, BookStatus.IN_STOCK, "Fds");
        Address userAddress = new Address(new Long(1), "Соломовой", "Гродно", "Гродненский", "Беоарусь", 240000);

        authorService.addAuthor(author);
        bookService.addBook(book);

        UserData userData = new UserData(new Long(1),user, "Bob", "White", "Black", role, "email", 21474836647L, userAddress);
        userData.getFavorites().add(book);
        userService.addUser(user);
        userDataService.updateUserData(userData);
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