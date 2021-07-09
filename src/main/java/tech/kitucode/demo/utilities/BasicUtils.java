package tech.kitucode.demo.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.processors.PreProcessor;

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
        // check the occurence of first space
        int firstSpacePosition = phrase.indexOf(" ");

        int secondSpacePosition = phrase.lastIndexOf(" ");

        String secondWord = phrase.substring(firstSpacePosition+1, secondSpacePosition);

        return secondWord;
    }

    public static String getThirdWord(String phrase){
        int lastSpacePosition = phrase.lastIndexOf(" ");

        String thirdWord = phrase.substring(lastSpacePosition+1);

        return thirdWord;
    }

    public static void main(String[] args) {
        System.out.println(getSecondWord("BUY 12345 300"));
    }


}
