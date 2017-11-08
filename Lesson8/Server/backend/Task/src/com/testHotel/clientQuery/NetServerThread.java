package com.testHotel.clientQuery;
import com.QueryData.QueryData.QueryData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
public class NetServerThread {
    public static void start() {
        try {
            ServerSocket serv = new ServerSocket(8071);
            System.out.println("initialized");
            while (true) {
//ожидание клиента
                Socket sock = serv.accept();
                System.out.println(
                        sock.getInetAddress().getHostName()
                                + " connected");
/*создание отдельного потока для обмена
данными с соединившимся клиентом*/
                ServerThread server = new ServerThread(sock);
                server.start();//запуск потока
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
class ServerThread extends Thread {
    private PrintStream os;//передача
    private BufferedReader is;//чтение
    private InetAddress addr;//адрес клиента
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));
        addr = s.getInetAddress();
    }
    public void run() {
        int i = 0;
        String str;
        try {
            while ((str = is.readLine()) != null) {

                    Object someObject=ClientQueryService.postClientQuery(str);
                    ObjectMapper objectMapper=new ObjectMapper();
                   String someString= objectMapper.writeValueAsString(someObject);
                    os.println(new String(someString));

            }
        } catch (IOException e) {
//если клиент не отвечает, соединение с ним разрывается
            System.out.println("Disconnect");
        } finally {
            disconnect();//уничтожение потока
        }
    }
    public void disconnect() {
        try {
            System.out.println(addr.getHostName()
                    + " disconnected");
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }

    }



    }

