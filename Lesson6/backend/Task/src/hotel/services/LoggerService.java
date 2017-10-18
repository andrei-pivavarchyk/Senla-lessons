package hotel.services;

import java.io.*;

public class LoggerService implements Serializable {

    private static LoggerService loggerService;

    private LoggerService(){

    }

    public static synchronized LoggerService getLoggerService(){
        if(loggerService==null){
            loggerService= new LoggerService();
        }
        return loggerService;
    }


    public void logInfo(String message){

        writeInFile("log information ",message);
    }

    public void logDanger(String message){

        writeInFile("log danger!!!!!!",message);
    }

    private void writeInFile(String header,String message){
        String pathToFile="././logs.txt";
        File file=new File(pathToFile);

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(header);
            bw.newLine();
            bw.write(message);
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
