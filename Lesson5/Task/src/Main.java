
import controller.MenuController;
import entity.Service;
import entity.ServiceType;
import service.LoggerService;
import service.MainService;

public class Main {

    public static void main(String[] args) {

        MainService.getMainService().startHotel( "D:\\Rooms.txt");


        MenuController menuController=new MenuController();
        menuController.run();

    }

    }
