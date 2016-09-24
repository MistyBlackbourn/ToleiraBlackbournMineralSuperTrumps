import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    int deckSize = 0;

    //adds a card to the deck and increments the size
    public void addCard(Card newCard){
        deck.add(newCard);
        ++deckSize;
    }

    //removes the top card from the deck and decrements the size
    public void takeCard(){
        deck.remove(deckSize-1);
        --deckSize;
    }

    //returns the size of the deck
    public int getDeckSize(){
        return deckSize;
    }
}
