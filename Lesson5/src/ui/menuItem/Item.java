package ui.menuItem;

import ui.Service.MenuService;
import ui.Service.ReflectionService;

import java.lang.reflect.Method;

/**
 * Created by андрей on 08.10.2017.
 */
public class Item  {

    private String title;
    private MenuService menuService;
    private String methodName;
    public Item(String title, MenuService mainController, String methodName) {
        this.title=title;
        this.menuService=mainController;
        this.methodName=methodName;
    }


    public void click() {

        try {

          Method method= ReflectionService.getReflectionService().getMethod(menuService,methodName);
            method.invoke(menuService);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }


    }

    public String getTitle() {
        return title;
    }
}
