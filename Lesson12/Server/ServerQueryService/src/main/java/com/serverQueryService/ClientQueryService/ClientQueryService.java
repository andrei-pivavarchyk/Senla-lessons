package com.serverQueryService.ClientQueryService;



import com.dependencyService.DependencyService;
import com.entity.HotelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClientQueryService implements IClientQueryService {

    public static Logger log = Logger.getLogger(ClientQueryService.class);
    public static IHotelController hotelController=(IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    public static Object queryHandler(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            QueryData queryData = mapper.readValue(message, QueryData.class);

            List<HotelEntity> allParametersList = queryData.getAllParamList();

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
            log.error(e.toString());
        } catch (IllegalAccessException e) {
            log.error(e.toString());
        } catch (InvocationTargetException e) {
            log.error(e.toString());
        }
        return null;
    }
}
