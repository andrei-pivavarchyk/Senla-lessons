package ui.menuItem;

import ui.controller.MainController;

import java.lang.reflect.Method;

/**
 * Created by андрей on 08.10.2017.
 */
public class Item extends  MenuItem {
    public Item(String title, MainController mainController, Method method) {
        super(title, mainController, method);
    }

    @Override
    public void click() {

        try {

            Class c = getMainController().getClass();
            Class[] paramTypes = new Class[]{String.class, int.class};
            Method method = c.getMethod("ShowMainMenu", paramTypes);
            Object[] args = new Object[]{new String("ShowMainMenu")};
            Double d = (Double) method.invoke(getMainController(), args);

        }
        catch(Exception e){
            System.out.println(e.toString());
        }


    }
}
