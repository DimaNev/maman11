package nevelev.dima;

import javax.swing.*;

/**
 * Dmitry Nevelev
 * 308877489
 * MAMAN 11 Q 1
 *
 */
public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();
        UserInterface userInterface = new UserInterface();
        boolean userGotIt =false;
        boolean gotCancel =false;

        while (!userGotIt){
            gotCancel =!userInterface.getNumber();
            if (gotCancel) {
                JOptionPane.showMessageDialog(null, "Goodbye");
                return;
            }
            userGotIt=userInterface.userGotIrRight(computer).get(0)=="true";
            if (userGotIt) userInterface.congratulate();
        }
    }
}
