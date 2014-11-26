package nevelev.dima;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * UserInterface: DimaN
 * Date: 01/11/14
 * Time: 09:29
 * This class represents the computer as a player of Cows and Bulls
 */
public class UserInterface {
    private Number number =new Number();
    private String pastGuesses ="";
    private int numOfPastGuesses =0;
    private int numberLength = number.getLength();

    public boolean getNumber(){
        do{
            String inputValue= JOptionPane.showInputDialog(getMessage());
            if (inputValue==null)return false;
            number.setNumber(inputValue);
            if (!number.isValid()){
                JOptionPane.showMessageDialog(null,number.getValidationAnswer(),"Wrong Input",JOptionPane.ERROR_MESSAGE);
            }
        }while (!number.isValid());
        return true;
    }

    public ArrayList<String> userGotIrRight(Computer computer){

        ArrayList<String> answer =new ArrayList<String>();
        answer.addAll(computer.compare(number.getNumber()));
        if (numOfPastGuesses ==0) pastGuesses ="Your past guesses are:\n";
        pastGuesses = pastGuesses +"Round "+(numOfPastGuesses +1)+": You choose "+number.getNumber()+" " +
                "-you got "+answer.get(1)+" Bulls and "+answer.get(2)+" Cows.\n";
        numOfPastGuesses++;
        return answer;
    }

    public void congratulate(){
        JOptionPane.showMessageDialog(null,"Congratulations!!! You won the game!!!\n" +
                "The number was "+number.getNumber()+".\n" +
                "You made "+ numOfPastGuesses +" guesses.");
    }

    private String getMessage(){
        String message="";
        if(numOfPastGuesses ==0){
            message="Hello Player,\n" +
                    "Welcome to the Cows and Bulls game.\n";
        }
        message=message+"Please provide number of "+numberLength+ " numerical digits. " +
                        "the digits must be all different!\n\n"+ pastGuesses;
        return message;
    }
}
