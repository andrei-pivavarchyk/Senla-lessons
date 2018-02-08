import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;

import java.io.IOException;

/**
 * Created by андрей on 08.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("fds", "Fds");
        String str = "{\"type\":\"User\",\"login\":\"fds\",\"password\":\"Fds\",\"id\":null}";

    }
}