package com.hotelInterface.querySenderService;

import com.QueryData.QueryData.QueryData;

import java.io.*;
import java.net.*;
public class ClientSocket  {
    public static Object start(QueryData message){
        try {
// установка соединения с сервером
            Socket s = new Socket(InetAddress.getLocalHost(), 8071);
//или Socket s = new Socket("ИМЯ_СЕРВЕРА", 8071);
            ObjectOutputStream ps = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());


                ps.writeObject(message);
            Object serverMessage= null;
            try {
                serverMessage = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);

            s.close();
            return serverMessage;
        } catch (UnknownHostException e) {
// если не удалось соединиться с сервером
            System.out.println("адрес недоступен");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ошибка I/О потока");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(
                    "ошибка потока выполнения");
            e.printStackTrace();
        }
        return null;
    }
}
