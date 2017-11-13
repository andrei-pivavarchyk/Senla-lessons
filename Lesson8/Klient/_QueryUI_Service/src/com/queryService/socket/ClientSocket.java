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

    private Socket s;

    private static ClientSocket clientSocket;

    private ClientSocket(){}

    public static synchronized ClientSocket getClientSocket() {
        if (clientSocket == null) {
            clientSocket = new ClientSocket();
        }
        return clientSocket;
    }


    public String send(QueryData message) {

        try {

            PrintStream ps = new PrintStream(this.s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            ObjectMapper mapper = new ObjectMapper();
            String someString = mapper.writeValueAsString(message);
            ps.println(someString);
            String serverAnswer = br.readLine();
            Thread.sleep(1000);

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

    public void start() {
        try {
            Socket newSocket = new Socket(InetAddress.getLocalHost(), 8071);
            this.s = newSocket;
        } catch (IOException e) {
            log.error(e.toString());
        }

    }

    public void closeSocket() {
        try {
            this.s.close();
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    public Socket getS() {
        return s;
    }
}
