package nevelev.dima;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * UserInterface: DimaN
 * Date: 01/11/14
 * Time: 08:22
 *
 * This class represents the computer as a player of Cows and Bulls
 */
public class Computer extends Number{

    public Computer(){
        this.setNumber(generateRandomNumber());
    }

    private String generateRandomNumber() {
        String generatedNumber="";
        String  digitAsString;

        for(int i=0; i<this.getLength(); i++){
            do{
                digitAsString = "" + Math.round( Math.random()*9 );
            }
            while(generatedNumber.contains(digitAsString));

            generatedNumber = generatedNumber + digitAsString;
        }

        return generatedNumber;
    }

    public ArrayList<String> compare(String otherNumber) {
        int numberOfBulls = 0;
        int numberOfCows = 0;
        String localCharToCompare;
        String otherCharToCompare;
        Boolean areTheSame;
        ArrayList<String> answer = new ArrayList<String>();

        for (int i=0; i<this.getLength(); i++){
            localCharToCompare = "" + this.getNumber().charAt(i);
            otherCharToCompare = "" + otherNumber.charAt(i);
            if(localCharToCompare.equals(otherCharToCompare)){
                numberOfBulls++;
            }
            else if(this.getNumber().contains(otherCharToCompare)){
                numberOfCows++;
            }
        }

        areTheSame= getLength() == numberOfBulls;
        answer.add(0, areTheSame.toString());
        answer.add(1, ""+numberOfBulls);
        answer.add(2, ""+numberOfCows);
        return answer;
    }
}