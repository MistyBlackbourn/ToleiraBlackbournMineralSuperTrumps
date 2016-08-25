import java.util.Collections;

public class CardDeck {
    Card[] cardDeck = new Card[60];
    int cardDeckSize = 0;

    //potentially need to change this so deck is random
    public void addCard(Card newCard){
        cardDeck[cardDeckSize] = newCard;
        ++cardDeckSize;
    }

    //doesn't delete from deck so as not to lose reference to card
    //also must add the taken card to the hand of the player
    public void takeCard(){
        Card topCard = cardDeck[cardDeckSize];
        --cardDeckSize;
    }

    public int getCardDeckSize(){
        return cardDeckSize;
    }
}
