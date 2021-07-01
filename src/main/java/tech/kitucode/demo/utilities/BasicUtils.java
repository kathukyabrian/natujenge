package tech.kitucode.demo.utilities;

public class BasicUtils {

    public String capitalize(String originalString){
        return originalString.substring(0,1).toUpperCase() + originalString.substring(1).toLowerCase();
    }

    public static String getFirstWord(String phrase){
        int i = phrase.indexOf(" ");

        String firstWord = phrase.substring(0, i);

        return firstWord.toUpperCase();
    }

    public static String getSecondWord(String phrase){
        // check the occurence of first space
        int firstSpacePosition = phrase.indexOf(" ");

        String secondPart = phrase.substring(firstSpacePosition+1);

        int secondSpacePosition = secondPart.indexOf(" ");

        String secondWord = secondPart.substring(0,secondSpacePosition);

        return secondWord.toUpperCase();
    }

    public static String getThirdWord(String phrase){
        int firstSpacePosition = phrase.indexOf(" ");

        String secondPart = phrase.substring(firstSpacePosition+1);

        int secondSpacePosition = secondPart.indexOf(" ");

        String thirdPart = secondPart.substring(secondSpacePosition+1);

        int thirdSpacePosition = thirdPart.indexOf(" ");

        String thirdWord =  thirdPart.substring(thirdSpacePosition+1);

        return thirdWord.toUpperCase();
    }


}
