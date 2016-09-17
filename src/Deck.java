import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    int deckSize = 0;

    public void addCard(Card newCard){
        deck.add(newCard);
        ++deckSize;
    }

    public void takeCard(){
        deck.remove(deckSize-1);
        --deckSize;
    }

    public int getDeckSize(){
        return deckSize;
    }
}
