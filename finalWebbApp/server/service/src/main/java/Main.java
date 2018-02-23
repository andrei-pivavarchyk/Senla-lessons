import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import com.service.TokenHandler;

/**
 * Created by андрей on 08.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("fds", "Fds");
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTdXBlcldlYkFwcCIsImlkIjoxLCJleHAiOjE1MTg3OTYxMjR9.YObeum6NOuAeZ2hQFvxd4CK7Oq8HUB7tfxYJdOHw_s4";
        TokenHandler tokenHandler=new TokenHandler();
        System.out.println( tokenHandler.createToken(new Long(1)));
        System.out.println( tokenHandler.getUserIdByToken(str));

    }
}