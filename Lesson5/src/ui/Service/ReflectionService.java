package ui.Service;


import ui.controller.MainController;

import java.lang.reflect.Method;

public class ReflectionService {

    private static ReflectionService reflectionService;


    private ReflectionService(){

    }

    public static ReflectionService getReflectionService(){
        if(reflectionService==null){
            reflectionService=new ReflectionService();
        }
        return reflectionService;
    }


    public Method getMethod(MenuService mainController, String methodName)  {

        try {
            Class c = mainController.getClass();
            Method m = c.getMethod(methodName);
            return m;
        }
        catch(NoSuchMethodException e){
            LoggerService.getLoggerService().logDanger(e.toString());
        }
        return null;
    }

}
