package ui.menuItem;

import ui.controller.MainController;

import java.lang.reflect.Method;

/**
 * Created by андрей on 08.10.2017.
 */
public class Item  {

    private String title;
    private MainController mainController;
    private String methodName;
    public Item(String title, MainController mainController, String methodName) {
        this.title=title;
        this.mainController=mainController;
        this.methodName=methodName;
    }


    public void click() {

        try {

            Class c = mainController.getClass();
            Class[] paramTypes = new Class[]{String.class};
            Method method = c.getMethod(methodName);
            Object[] args = new Object[]{new String("ShowMainMenu")};
             method.invoke(mainController);

        }
        catch(Exception e){
            System.out.println(e.toString());
        }


    }

    public String getTitle() {
        return title;
    }
}
