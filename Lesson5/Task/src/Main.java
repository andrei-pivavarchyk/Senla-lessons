
import controller.MenuController;
import service.MainService;

public class Main {

    public static void main(String[] args) {

        MainService.getMainService().startHotel( "D:\\Rooms.txt");


        MenuController menuController=new MenuController();
        menuController.run();

    }

    }
