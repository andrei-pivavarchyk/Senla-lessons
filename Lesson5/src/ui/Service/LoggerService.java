package ui.Service;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerService {

    private static LoggerService loggerService;

    private LoggerService(){

    }

    public static LoggerService getLoggerService(){
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
        String pathToFile="D:\\"+"logs.txt";
        File file=new File(pathToFile);


        try
        {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            // пишем данные
            bw.write(header);
            bw.write(message);
            // закрываем поток
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
