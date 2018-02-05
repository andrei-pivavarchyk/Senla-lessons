import com.model.User;
import com.service.api.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        IUserService userService=context.getBean(IUserService.class);
        User user=new User("cds","fdsdddddddd");
        userService.addUser(user);

    }
}
