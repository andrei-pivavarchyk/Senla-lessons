package com.testHotel.clientQuery;
import com.QueryData.QueryData.QueryData;

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
    private ObjectOutputStream os;//передача
    private ObjectInputStream is;//чтение
    private InetAddress addr;//адрес клиента
    public ServerThread(Socket s) throws IOException {
        os = new ObjectOutputStream(s.getOutputStream());
        is = new ObjectInputStream(s.getInputStream());
        addr = s.getInetAddress();
    }
    public void run() {

        QueryData obj;

        try {
            while ((obj = (QueryData)is.readObject()) != null) {

                ClientQueryService clientQueryService=new ClientQueryService();

                //ответ клиенту
            Object object= clientQueryService.postClientQuery(obj);
                   os.writeObject(object);

                System.out.println("Отпрален ответ клиенту" + addr.getHostName());

            }
        } catch (IOException e) {
//если клиент не отвечает, соединение с ним разрывается
            System.out.println("Disconnect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
