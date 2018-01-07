package com.serverQueryService.main;

import com.dependencyService.DependencyService;
import com.entity.HotelEntity;
import com.entity.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverQueryService.ClientQueryService.*;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        ObjectToJsonConverter objectToJsonConverter=new ObjectToJsonConverter();

        IClientQueryService clientQueryService=(IClientQueryService) DependencyService.getDI().getInstance(IClientQueryService.class);

      String someMethod="addRoom";
        Room room=new Room(12,22,33,44,55);
        List<HotelEntity> allParameters=new ArrayList<HotelEntity>();
        allParameters.add(room);

        QueryData queryData=new QueryData(someMethod,allParameters);

        String query=ObjectToJsonConverter.convertObject(queryData);
System.out.print(query);
/*
        ObjectMapper mapper = new ObjectMapper();
        String str=ObjectToJsonConverter.convertObject(queryData);
        try {
                QueryData queryData1=  mapper.readValue(str, QueryData.class);

            Object hHotelEntity=queryData1.getAllParamList().get(0);
            System.out.println(hHotelEntity.getClass().getName());
                Room rrr=(Room) hHotelEntity;
            System.out.println(rrr.getCost());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }
}
