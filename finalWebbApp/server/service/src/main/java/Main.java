import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import com.service.TokenHandler;

/**
 * Created by андрей on 08.02.2018.
 */
public class Main {
    public static void main(String[] args) {

TokenHandler tokenHandler=new TokenHandler();
String token=tokenHandler.createToken(1);
tokenHandler.getUserIdByToken(token);
System.out.print(token);
    }
}