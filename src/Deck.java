import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    int deckSize = 0;

    public void addCard(Card newCard){
        deck.add(newCard);
        ++deckSize;
    }

    //doesn't delete from deck so as not to lose reference to card
    //also must add the taken card to the hand of the player
    public void takeCard(){
        deck.remove(deckSize-1);
        --deckSize;
    }

    public int getDeckSize(){
        return deckSize;
    }
}
