package com.testHotel.clientQuery;


import com.QueryData.QueryData.QueryData;
import com.dependencyService.DependencyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClientQueryService {

    public static Object postClientQuery(String message) {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(message);


        try {


            QueryData queryData = mapper.readValue(message, QueryData.class);


            List<Class> allParameterClassList = queryData.getParameterClassList();
            List<Object> allParametersList = queryData.getAllParamList();
            String someMethodName = queryData.getSomeMethod();
            Class someClass = queryData.getSomeClass();

            Class c = DependencyService.getDI().getInstance(someClass).getClass();

            Class[] paramClassArray = new Class[allParametersList.size()];
            Object[] allParametersArray = new Object[allParametersList.size()];
            int i = 0;
            for (Object someParameter : allParametersList) {
                paramClassArray[i] = allParameterClassList.get(i);
                allParametersArray[i] = allParametersList.get(i);
                i++;
            }

        Method method = null;

        if (allParameterClassList.isEmpty()) {

            try {
                method = someClass.getDeclaredMethod(someMethodName);
                Object returnObject = method.invoke(DependencyService.getDI().getInstance(someClass));
                return returnObject;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {

            try {
                method = someClass.getDeclaredMethod(someMethodName, paramClassArray);
                Object returnObject = method.invoke(DependencyService.getDI().getInstance(someClass), allParametersArray);
                return returnObject;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
