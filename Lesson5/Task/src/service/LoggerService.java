package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class LoggerService {

    private static LoggerService loggerService;

    private LoggerService(){

    }

    public static synchronized LoggerService getLoggerService(){
        if(loggerService==null){
            loggerService=new LoggerService();
        }
        return loggerService;
    }


    public void logInfo(String message){
        writeInFile("logI nfo",message);
    }

    public void logDanger(String message){
        writeInFile("logI danger!!!!!!",message);
    }

    private void writeInFile(String header,String message){
        String pathToFile="logs.txt";
        File file=new File(pathToFile);


        try
        {

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            // пишем данные
            bw.write(header);
            bw.write(message);

            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
