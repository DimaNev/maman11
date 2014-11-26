package nevelev.dima;

/**
 * Created with IntelliJ IDEA.
 * User: DimaN
 * Date: 07/11/14
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class WarGame {

    private DeckOfCards gameDeck;
    private DeckOfCards player1;
    private DeckOfCards player2;
    private DeckOfCards player1RoundCards;
    private DeckOfCards player2RoundCards;
    private String winner = "";
    private static final int NUMBER_OF_CARD_IN_REGULAR_ROUND = 2;
    private static final int NUMBER_OF_CARD_IN_REPEATING_ROUND = 3;
    private String gameLog="Starting New Game!\n";


    public WarGame() {
        this.gameDeck = new DeckOfCards(false);
        this.player1 = new DeckOfCards(true);
        this.player2 = new DeckOfCards(true);
        this.player1RoundCards = new DeckOfCards(true);
        this.player2RoundCards = new DeckOfCards(true);
    }


    public void ShuffleGameDeck(){
        DeckOfCards tempDeck =new DeckOfCards(true);

        tempDeck.getAllCardsInRandomOrder(this.gameDeck);
        this.gameDeck.getAllCardsInRandomOrder(tempDeck);
    }


    public void dealCards(){
        while (gameDeck.size()!=0){
            this.player1.getCardsToTopReversed(gameDeck, 1);
            this.player2.getCardsToTopReversed(gameDeck, 1);
        }
    }


    public void playRound(){
        getCardsFromPlayer(1,true);
        getCardsFromPlayer(2,true);
        gameLog = gameLog + generatePlayerString(1) + generatePlayerString(2);

        while (player1RoundCards.getTopCardValue() == player2RoundCards.getTopCardValue()){
            gameLog = gameLog + "It's a tie! lets replay!!\n";
            getCardsFromPlayer(1, false);
            getCardsFromPlayer(2, false);
            gameLog = gameLog + generatePlayerString(1) + generatePlayerString(2);
        }
        gameLog=gameLog+ generateWinnerString();
        giveTheCardsToTheWinner();
    }


    public boolean gameFinished(){
        if(this.player1.size()==0){
            winner="Player 2";
            return true;
        }
        else if (this.player2.size()==0){
            winner="Player 1";
            return true;
        }
        else return false;
    }


    public String getWinner(){
        return this.winner;
    }


    public String getGameLog(){
        return this.gameLog;
    }


    private void giveTheCardsToTheWinner(){
        if(player1RoundCards.getTopCardValue() > player2RoundCards.getTopCardValue()){
            player1.getCardsToBottomInOrder(player1RoundCards, player1RoundCards.size());
            player1.getCardsToBottomInOrder(player2RoundCards, player2RoundCards.size());
        }
        else{
            player2.getCardsToBottomInOrder(player2RoundCards, player2RoundCards.size());
            player2.getCardsToBottomInOrder(player1RoundCards, player1RoundCards.size());
        }
    }


    private String generateWinnerString(){
        if (player1RoundCards.getTopCardValue() > player2RoundCards.getTopCardValue()){
            return "Player 1 won this round!\n";
        }
        return "Player 2 won this round!\n";
    }


    private String generatePlayerString(int playerNumber){
        String string="";
        if(playerNumber==1) {
            string="Player 1 got "+ player1RoundCards.getTopCardDescription()+", ";
        }
        else if(playerNumber==2){
            string="Player 2 got "+ player2RoundCards.getTopCardDescription()+".   ";
        }
        return string;
    }


    private void getCardsFromPlayer(int playerNumber, boolean regularRound){
        int numberOfCards = (regularRound) ? NUMBER_OF_CARD_IN_REGULAR_ROUND : NUMBER_OF_CARD_IN_REPEATING_ROUND;
        if(playerNumber==1){
            player1RoundCards.getCardsToTopReversed(player1, numberOfCards);
        }
        else{
            player2RoundCards.getCardsToTopReversed(player2, numberOfCards);
        }
    }
}