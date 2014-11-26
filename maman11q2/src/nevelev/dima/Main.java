package nevelev.dima;


import javax.swing.*;
import java.awt.*;

/**
 * Dmitry Nevelev
 * 308877489
 * MAMAN 11 Q 2
 *
 */
public class Main {

    public static void main(String[] args) {
        int result = 0;
        WarGame warGame = new WarGame();
        String[] options = new String[] {"Play One Round", "Play Till End", "End This Game"};

        warGame.ShuffleGameDeck();
        warGame.dealCards();

        do{
            if (result != 1){
                result=JOptionPane.showOptionDialog(null, warGame.getGameLog()+"\nWhat do you want to do?", "War Game",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            }
            warGame.playRound();
            if (result==-1) result=2;
        }while(!warGame.gameFinished() && result != 2);

        if (result == 2){
            JOptionPane.showMessageDialog(null,"Sorry you cold not finish the game!!!\n");
        }
        else {
            JTextArea textArea = new JTextArea(warGame.getGameLog()+"Congratulations!!! "+warGame.getWinner()+" won the game!!!\n");
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );

            JOptionPane.showMessageDialog(null,scrollPane);
        }
    }
}
