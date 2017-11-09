package com.queryService.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.queryService.queryEntity.QueryData;
import com.queryService.service.ClientService;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    public static final Logger log = Logger.getLogger(ClientService.class);
    public static String start(QueryData message) {

        try {

            Socket s = new Socket(InetAddress.getLocalHost(), 8071);
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ObjectMapper mapper = new ObjectMapper();
            String someString= mapper.writeValueAsString(message);
            ps.println(someString);
            String serverAnswer=br.readLine();
            Thread.sleep(1000);
            s.close();
            return serverAnswer;
        } catch (UnknownHostException e) {
           log.error(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error(e.toString());
        }
        return null;
    }
}
