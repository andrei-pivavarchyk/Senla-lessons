import com.dao.api.IUserDAO;
import com.model.User;
import com.model.UserData;
import com.service.TokenHandler;
import com.service.api.IUserDataService;
import com.service.api.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        IUserService userService = context.getBean(IUserService.class);
        IUserDataService userDataService = context.getBean(IUserDataService.class);
        IUserDAO userDao = context.getBean(IUserDAO.class);
        userDataService.getUserDataByUserId(new Long(1));
        System.out.print(userDataService.getUserDataByUserId(new Long(1)).getName());
    }
}
