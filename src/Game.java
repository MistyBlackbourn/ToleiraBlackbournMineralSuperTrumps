import java.util.ArrayList;
import java.util.Collections;

public class Game {
    Deck cardDeck = new Deck();
    ArrayList<Player> players = new ArrayList<>();

    public void createPlayers(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    //For testing Card and Deck class.
    //This needs to be changed to read xml file.
    public void createCards() {
        String[] array = new String[3];
        Card card1 = new Card("Quartz", "play", "SiO_2", "tectosilicate", "hexagonal", array, 7, 2.65, "poor/none", "high", "moderate");
        Card card2 = new Card("Plagioclase", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", array, 6 - 6.5, 2.6 - 2.8, "1 perfect. 1 good", "very high", "moderate");
        Card card3 = new Card("Card Three", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", array, 6 - 6.5, 2.6 - 2.8, "1 perfect. 1 good", "very high", "moderate");
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
    }

    public void shuffleDeck() {
        Collections.shuffle(cardDeck.deck);
    }

    public void dealCards() {
        for (int j = 0; j < players.size(); ++j) {
            for (int i = 0; i < 8; ++i) {
                players.get(j).playersHand.add(cardDeck.deck.get(i));
                //System.out.println("Player " + j + " " + players.get(j).playersHand.get(i).cardType);
            }

        }
    }

    public StringBuilder getPlayerCards(ArrayList<Card> playersHand) {
        StringBuilder stringBuilder = new StringBuilder();
        int cardNumber = 0;
        for (Card card : playersHand) {
            stringBuilder.append(cardNumber + 1);
            stringBuilder.append(" | ");
            stringBuilder.append(card.cardType);
            stringBuilder.append(" | ");
            stringBuilder.append(card.title);
            stringBuilder.append(" | ");
            stringBuilder.append(card.chemistry);
            stringBuilder.append(" | ");
            stringBuilder.append(card.classification);
            stringBuilder.append(" | ");
            stringBuilder.append(card.crustalAbundance);
            stringBuilder.append(" | ");
            stringBuilder.append(card.cleavage);
            stringBuilder.append(" | ");
            stringBuilder.append(card.crystalSystem);
            stringBuilder.append(" | ");
            stringBuilder.append(card.economicValue);
            stringBuilder.append("\n");
            ++cardNumber;
        }
        stringBuilder.append(0);
        stringBuilder.append(" | ");
        stringBuilder.append("PASS");

        return stringBuilder;

    }

}
