


import com.model.*;
import com.service.ObjectConverter;
import com.serviceAPI.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

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
        Author author = new Author(1,"bob","bob",new Date());


       Map map=new HashMap<>();
       map.put("first",1);
       map.put("max",2);
        ObjectConverter objectConverter=new ObjectConverter();

        System.out.print(objectConverter.convertObject(map));


    }
}