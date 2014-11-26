package nevelev.dima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: DimaN
 * Date: 06/11/14
 * Time: 00:40
 * To change this template use File | Settings | File Templates.
 */
public class DeckOfCards {

    private List<Object> deck;
    private String[] facesNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suitsNames = {"Hearts", "Spades", "Diamonds", "Clubs"};
    private List <String> faces = new ArrayList<String>(Arrays.asList(facesNames));
    private List <String> suites = new ArrayList<String>(Arrays.asList(suitsNames));


    /**
     * A constractor,
     * will create a deck of card with 52 cards if createEmptyDeck value is false,
     * if createEmptyDeck value is true an empty deck will be created.
     * @param createEmptyDeck should the deck be empty?
     */
    public DeckOfCards (boolean createEmptyDeck){
        this.deck = new ArrayList<Object>();

        if (!createEmptyDeck){
            for (String i : faces){
                for (String j : suites){
                    deck.add(new Card(i, j));
                }
            }
        }
    }


    /**
     * Gets the top card value as a numeric value
     * @return top card value as numeric value
     */
    public int getTopCardValue(){
        return getCardValue(this.getCardOnIndex(0));
    }


    public String getTopCardDescription(){
        return this.getCardOnIndex(0).toString();
    }


    /**
     * Gets cards to this deck from some other deck.
     * sets them in reversed order to the top of this deck.
     * the cards will be deleted in the other deck.
     * @param deckToGetFrom
     * @param numberOfCadsToGet number of cards to move from the other deck
     */
    public void getCardsToTopReversed(DeckOfCards deckToGetFrom, int numberOfCadsToGet){
        if(numberOfCadsToGet > deckToGetFrom.size()) numberOfCadsToGet = deckToGetFrom.size();

        for(int i=0; i<numberOfCadsToGet; i++){
            Card topCard = deckToGetFrom.getCardOnIndex(0);
            if (topCard.getFace()!="nill"){
                this.addCardToIndex(topCard, 0);
                deckToGetFrom.removeCard(0);
            }
        }
    }


    public void getCardsToBottomInOrder(DeckOfCards deckToGetFrom, int numberOfCadsToGet){
        if(numberOfCadsToGet > deckToGetFrom.size()) numberOfCadsToGet = deckToGetFrom.size();

        for(int i=0; i<numberOfCadsToGet; i++){
            Card topCard = deckToGetFrom.getCardOnIndex(0);
            if (topCard.getFace()!="nill"){
                this.addCard(topCard);
                deckToGetFrom.removeCard(0);
            }
        }
    }


    /**
     * returns the deck size
     * @return int which represents the deck size
     */
    public int size(){
        return this.deck.size();
    }


    /**
     * Gets all cards by random order from other deck and sets them into this deck
     * @param deckToGetFrom
     */
    public void getAllCardsInRandomOrder(DeckOfCards deckToGetFrom){
        int randomNumber;

        while (deckToGetFrom.size()>0){
            randomNumber=generateRandomInt(deckToGetFrom.size()-1);
            if(randomNumber<0)randomNumber=0;
            this.addCardToIndex(deckToGetFrom.getCardOnIndex(randomNumber),0);
            deckToGetFrom.removeCard(randomNumber);
        }
    }


    /**
     * Removes the card from index
     * @param index
     */
    private void removeCard(int index){
        this.deck.remove(index);
    }


    /**
     * gets the card value as a numeric value
     * @param card card to get the value from
     * @return card value as numeric value
     */
    private int getCardValue(Card card){
        return (int)faces.indexOf(card.getFace());
    }


    private int generateRandomInt(int topBoundary){
        Random random = new Random();
        return random.nextInt(topBoundary + 1);

    }


    /**
     * Return new instance of a card from specified index
     * if the index not exists in the deck, "nill" card will be returned
     * @param index were from to det a card
     * @return new card or a nill card
     */
    private Card getCardOnIndex(int index){
        Card card;
        if (this.deck.get(index)==null){
            return new Card("nill","nill");
        }
        card = (Card)this.deck.get(index);
        return new Card(card.getFace(),card.getSuit());
    }


    public String toString() {
        String deck="DeckOfCards{";
        for (int i=0; i<this.size(); i++){
            deck=deck+", "+this.getCardOnIndex(i).toString();
        }
        deck=deck+"}";
        return deck;
    }


    /**
     * This method will add a card to an index.
     * If the index is higher than the deck size the card will be added to the end of the deck.
     * @param card to add
     * @param index were to add
     */
    private void addCardToIndex(Card card, int index){
        if (index>this.size())index=this.size();
        this.deck.add(index, new Card(card.getFace(), card.getSuit()));
    }


    private void addCard(Card cardToAdd){
        this.deck.add(cardToAdd);
    }
}