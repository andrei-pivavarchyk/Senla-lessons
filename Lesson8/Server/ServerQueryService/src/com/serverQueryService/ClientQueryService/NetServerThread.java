package com.serverQueryService.ClientQueryService;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;
public class NetServerThread {
    public static Logger log = Logger.getLogger(NetServerThread.class);

    public static void start() {
        try {
            ServerSocket serv = new ServerSocket(8071);
            log.info("Server run");
            while (true) {
                Socket sock = serv.accept();
                log.info(sock.getInetAddress().getHostName()+"connect");
                ServerThread server = new ServerThread(sock);
                server.start();
            }
        } catch (IOException e) {
            log.error(e.toString());
        }
    }
}
