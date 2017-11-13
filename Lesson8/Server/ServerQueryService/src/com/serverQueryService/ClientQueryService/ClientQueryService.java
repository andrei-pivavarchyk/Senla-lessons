package com.serverQueryService.ClientQueryService;


import com.dependencyService.DependencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClientQueryService implements IClientQueryService {
    private static IHotelController hotelController= (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);

    public static Object queryHandler(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            QueryData queryData = mapper.readValue(message, QueryData.class);
            List<Object> allParametersList = queryData.getAllParamList();
            String someMethodName = queryData.getSomeMethod();

            Class c = hotelController.getClass();

            Object[] allParametersArray = new Object[allParametersList.size()];
            int i = 0;
            for (Object someParameter : allParametersList) {
                allParametersArray[i] = allParametersList.get(i);
                i++;
            }

            Method method = null;
            Method[] methodArray = c.getDeclaredMethods();
            for (Method someMethod : methodArray) {
                if (someMethod.getName().equals(someMethodName)) {
                    method = someMethod;
                }
            }

            if (allParametersList.isEmpty() && method != null) {
                Object returnObject = method.invoke(hotelController);
                return returnObject;

            } else if (method != null) {
                Object returnObject = method.invoke(hotelController, allParametersArray);
                return returnObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
