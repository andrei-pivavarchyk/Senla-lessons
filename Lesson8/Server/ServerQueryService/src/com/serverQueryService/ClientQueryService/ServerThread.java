package com.serverQueryService.ClientQueryService;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;
    public static Logger log = Logger.getLogger(NetServerThread.class);
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }
    public void run() {
        int i = 0;
        String str;
        try {
            while ((str = is.readLine()) != null) {
                Object someObject=ClientQueryService.queryHandler(str);
                String requestString=  ObjectConverter.convertObject(someObject);
                os.println(requestString);
            }
        } catch (IOException e) {
        } finally {
            this.disconnect();
        }
    }
    public void disconnect() {
        try {
            log.error("Disconnect");
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}

