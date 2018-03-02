import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Book;
import com.model.BookGenre;
import com.model.Role;
import com.model.User;
import com.service.ObjectConverter;
import com.service.TokenHandler;

import javax.jws.soap.SOAPBinding;


public class Main {
    public static void main(String[] args) {

ObjectConverter objectConverter=new ObjectConverter();
System.out.print(objectConverter.convertObject(new User()));
    }
}