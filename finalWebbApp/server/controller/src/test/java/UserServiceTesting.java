import com.service.UserService;
import com.serviceAPI.IUserService;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserServiceTesting {
    private ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/root-context.xml");
private IUserService userService;
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before creating class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After creating class");
    }

    @Before
    public void initTest() {
        userService=this.context.getBean(IUserService.class);
        System.out.print(userService);
    }

    @After
    public void afterTest() {
        userService = null;
    }

    @Test
    public void testCreateUser() throws Exception {
       // assertEquals(15, calculator.getSum(7,8));
        assertEquals(true, true);
    }






    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }

  /*  @Test(timeout = 500)
    public void timeStampTest() {
        while (true);
    }*/
}
