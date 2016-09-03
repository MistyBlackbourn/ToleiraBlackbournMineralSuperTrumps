import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    Deck cardDeck = new Deck();
    Deck playDeck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    String cardCategory;
    int playersTurn = 0;

    public void createPlayers(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    //For testing Card and Deck class.
    //This needs to be changed to read xml file.
    public void createCards() {
        Card card1 = new Card("Quartz", "play", "SiO_2", "tectosilicate", "hexagonal", "occurrence", 7, 2.65, "poor/none", "high", "moderate");
        Card card2 = new Card("Plagioclase", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", 6 - 6.5, 2.6 - 2.8, "1 perfect. 1 good", "very high", "moderate");
        Card card3 = new Card("Card Three", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", 6 - 6.5, 2.6 - 2.8, "1 perfect. 1 good", "very high", "moderate");
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

    // randomly selects a dealer and sets the which player goes first
    public void dealCards() {
        int dealer;
        Random random = new Random();
        dealer = random.nextInt(players.size());
        System.out.println("Dealer is" + dealer);

        for (int i = 0; i < 8; ++i) {
            int cardsDealt = 0;
            System.out.println("New round " + i);
            for (playersTurn = dealer + 1; cardsDealt < players.size(); ++playersTurn) {
                if (playersTurn >= players.size() && cardsDealt < players.size()) {
                    playersTurn = 0;
                }
                players.get(playersTurn).playersHand.add(cardDeck.deck.get(i));

                System.out.println("Player " + playersTurn + " " + players.get(playersTurn).playersHand.get(i).title);
                ++cardsDealt;
            }

        }
    }

    public void validPlayer() {
        if (playersTurn >= players.size()) {
            playersTurn = 0;
        }
    }

    public void nextPlayer() {
        if (playersTurn >= players.size()) {
            playersTurn = 0;
        } else {
            ++playersTurn;
        }

    }

    public void drawCard() {
        cardDeck.takeCard();
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
            stringBuilder.append(card.crystalSystem);
            stringBuilder.append(" | ");
            stringBuilder.append(card.occurrence);
            stringBuilder.append(" | ");
            stringBuilder.append(card.hardness);
            stringBuilder.append(" | ");
            stringBuilder.append(card.specificGravity);
            stringBuilder.append(" | ");
            stringBuilder.append(card.cleavage);
            stringBuilder.append(" | ");
            stringBuilder.append(card.crustalAbundance);
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

    public boolean checkCard(Card selectedCard) {
        boolean validCard = false;
        Card lastCardPlayed;
        if (playDeck.deckSize == 0) {
            return true;
        } else {
            lastCardPlayed = playDeck.deck.get(playDeck.getDeckSize() - 1); // will be used for comparisons
        }

        //each switch case must compare the cardCategory of selectedCard with the lastCardPlayed

        switch (cardCategory) {
            case "hardness":
                validCard = true;
                break;
            case "specific gravity":
                validCard = false;
                break;
            case "cleavage":
                validCard = true;
                break;
            case "crustal abundance":
                validCard = true;
                break;
            case "economic value":
                validCard = true;
                break;
        }

        return validCard;
    }

}
