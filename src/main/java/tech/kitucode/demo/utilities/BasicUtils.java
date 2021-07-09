package tech.kitucode.demo.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.processors.PreProcessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BasicUtils {

    private static final Logger logger = LogManager.getLogger(BasicUtils.class);

    public String capitalize(String originalString){
        return originalString.substring(0,1).toUpperCase() + originalString.substring(1).toLowerCase();
    }

    public static String getFirstWord(String phrase){

        int i = 0;

        try{
            i = phrase.indexOf(" ");
        }catch (StringIndexOutOfBoundsException e){
           logger.debug("Index is out of position");
        }

        String firstWord = phrase.substring(0, i);

        return firstWord.toUpperCase();
    }

    public static String getSecondWord(String phrase){

        String secondWord = null;
        // check the occurence of first space
        int spacePosition = phrase.indexOf(" ");

        int lastSpacePosition = phrase.lastIndexOf(" ");

        if(spacePosition==lastSpacePosition){
            secondWord = phrase.substring(spacePosition+1);
        }else{
            secondWord = phrase.substring(spacePosition+1,lastSpacePosition);
        }

        return secondWord;

    }

    public static String getThirdWord(String phrase){
        int lastSpacePosition = phrase.lastIndexOf(" ");

        String thirdWord = phrase.substring(lastSpacePosition+1);

        return thirdWord;
    }

    public static void writeToSocket(Socket socket, double doubleValue){
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(doubleValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToSocket(Socket socket, String string){
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
