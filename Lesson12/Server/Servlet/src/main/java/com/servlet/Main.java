package com.servlet;


import com.dao.IRoomDAO;
import com.dependencyService.DependencyService;
import com.propertyService.PPropertyService;
import com.serverQueryService.ClientQueryService.ClientQueryService;
import com.testHotel.controller.IHotelController;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class Main {
    public static void main(String[] args){

        String query="{\"someMethod\":\"addRoom\",\"allParamList\":[{\"type\":\"room\",\"id\":1,\"number\":2,\"cost\":35,\"capacity\":4,\"stars\":5,\"status\":\"FREE\"}]}";
        ClientQueryService.queryHandler(query);
    }
}
