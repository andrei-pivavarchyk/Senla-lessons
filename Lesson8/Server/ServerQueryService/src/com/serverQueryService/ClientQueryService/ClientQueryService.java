package com.serverQueryService.ClientQueryService;


import com.dependencyService.DependencyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClientQueryService implements IClientQueryService {

    public static Object queryHandler(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            QueryData queryData = mapper.readValue(message, QueryData.class);
            List<Object> allParametersList = queryData.getAllParamList();
            String someMethodName = queryData.getSomeMethod();
            String someClassName = queryData.getSomeClass();

            Class someClass = Class.forName(someClassName);
            Class c = DependencyService.getDI().getInstance(someClass).getClass();

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
                Object returnObject = method.invoke(DependencyService.getDI().getInstance(someClass));
                return returnObject;

            } else if (method != null) {
                Object returnObject = method.invoke(DependencyService.getDI().getInstance(someClass), allParametersArray);
                return returnObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
