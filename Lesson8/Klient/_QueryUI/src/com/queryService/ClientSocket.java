package com.queryService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    public static String start(QueryData message) {

        try {
// установка соединения с сервером
            Socket s = new Socket(InetAddress.getLocalHost(), 8071);
//или Socket s = new Socket("ИМЯ_СЕРВЕРА", 8071);
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            ObjectMapper mapper = new ObjectMapper();
            String someString= mapper.writeValueAsString(message);
            ps.println(someString);
            String someString2=br.readLine();
            Thread.sleep(1000);
            s.close();
            return someString2;
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
