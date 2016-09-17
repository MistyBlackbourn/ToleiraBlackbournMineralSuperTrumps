import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    Deck cardDeck = new Deck();
    Deck playDeck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> winningPlayers = new ArrayList<>();
    String cardCategory;
    boolean categoryIsSelected = false;
    boolean newCategorySelected = false;
    int playersTurn = 0;

    public void createPlayers(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    //For testing Card and Deck class.
    //This needs to be changed to read xml file.
    public void createCards() {
        Card card1 = new Card("Quartz", "play", "SiO_2", "tectosilicate", "hexagonal", "occurrence", "7", "2.65", "none", "ultratrace", "moderate");
        Card card2 = new Card("Plagioclase", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", "6-6.5", "2.6-2.8", "1 perfect, 1 good", "trace", "moderate");
        Card card3 = new Card("Card Three", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", "6-6.5", "2.6-2.8", "2 perfect", "low", "moderate");
        Card card4 = new Card("Quartz", "play", "SiO_2", "tectosilicate", "hexagonal", "occurrence", "7", "2.65", "poor/none", "moderate", "moderate");
        Card card5 = new Card("Plagioclase", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", "6-6.5", "2.6-2.8", "1 perfect, 2 good", "high", "moderate");
        Card card6 = new Card("Card Three", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", "occurrence", "6-6.5", "2.6-2.8", "4 perfect", "very high", "moderate");
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);
        cardDeck.addCard(card1);
        cardDeck.addCard(card2);
        cardDeck.addCard(card3);
        cardDeck.addCard(card4);
        cardDeck.addCard(card5);
        cardDeck.addCard(card6);

    }

    public boolean playersPassed() {
        int count = 0;
        for (Player player : players) {
            if (player.getPassed()) {
                ++count;
            }
        }
        return count >= (players.size() - 1);

    }

    public void shuffleDeck() {
        Collections.shuffle(cardDeck.deck);
    }

    // randomly selects a dealer and sets the player that goes first
    public void dealCards() {
        int dealer;
        Random random = new Random();
        dealer = random.nextInt(players.size());
        //System.out.println("Dealer is" + dealer);

        for (int i = 0; i < 8; ++i) {
            int cardsDealt = 0;
            //System.out.println("New round " + i);
            for (playersTurn = dealer + 1; cardsDealt < players.size(); ++playersTurn) {
                if (playersTurn >= players.size() && cardsDealt < players.size()) {
                    playersTurn = 0;
                }
                players.get(playersTurn).getPlayersHand().add(cardDeck.deck.get(i));
                //System.out.println("Before deck size " + cardDeck.deckSize);
                cardDeck.takeCard();
                //System.out.println("After deck size " + cardDeck.deckSize);
                //System.out.println("Player " + playersTurn + " " + players.get(playersTurn).playersHand.get(i).title);
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
        players.get(playersTurn).getPlayersHand().add(cardDeck.deck.get(cardDeck.deckSize - 1));
        players.get(playersTurn).setHandSize(true);
        players.get(playersTurn).setPassed(true);
        cardDeck.takeCard();
    }

    public void resetPlayersPassed() {
        for (Player player : players) {
            player.setPassed(false);
            System.out.println(player.getPassed());

        }
    }

    public StringBuilder getPlayerCards(ArrayList<Card> playersHand) {
        StringBuilder stringBuilder = new StringBuilder();
        int cardNumber = 0;
        for (Card card : playersHand) {
            stringBuilder.append(cardNumber + 1);
            stringBuilder.append(" | ");
            stringBuilder.append(card.getCardType());
            stringBuilder.append(" | ");
            stringBuilder.append(card.getTitle());
            stringBuilder.append(" | ");
            stringBuilder.append(card.getChemistry());
            stringBuilder.append(" | ");
            stringBuilder.append(card.getClassification());
            stringBuilder.append(" | ");
            stringBuilder.append(card.getCrystalSystem());
            stringBuilder.append(" | ");
            stringBuilder.append(card.getOccurrence());
            stringBuilder.append("\n");
            stringBuilder.append("Hardness: ");
            stringBuilder.append(card.getHardness());
            stringBuilder.append("\n");
            stringBuilder.append("Specific Gravity: ");
            stringBuilder.append(card.getSpecificGravity());
            stringBuilder.append("\n");
            stringBuilder.append("Cleavage: ");
            stringBuilder.append(card.getCleavage());
            stringBuilder.append("\n");
            stringBuilder.append("Crustal Abundance: ");
            stringBuilder.append(card.getCrustalAbundance());
            stringBuilder.append("\n");
            stringBuilder.append("Economic Value: ");
            stringBuilder.append(card.getEconomicValue());
            stringBuilder.append("\n");
            stringBuilder.append("\n");
            ++cardNumber;
        }
        stringBuilder.append(0);
        stringBuilder.append(" | ");
        stringBuilder.append("PASS");

        return stringBuilder;

    }

    public StringBuilder playerSelection() {
        String value = "";
        Card lastCardPlayed = playDeck.deck.get(playDeck.getDeckSize() - 1);

        switch (cardCategory) {
            case "hardness":
                String[] lastHardness;
                lastHardness = lastCardPlayed.getHardness().split("-");
                value = lastHardness[lastHardness.length - 1];
                break;
            case "specific gravity":
                String[] lastSpecificGravity;
                lastSpecificGravity = lastCardPlayed.getSpecificGravity().split("-");
                value = lastSpecificGravity[lastSpecificGravity.length - 1];
                break;
            case "cleavage":
                value = lastCardPlayed.getCleavage();
                break;
            case "crustal abundance":
                value = lastCardPlayed.getCrustalAbundance();
                break;
            case "economic value":
                value = lastCardPlayed.getEconomicValue();
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lastCardPlayed.getTitle());
        stringBuilder.append(", ");
        stringBuilder.append(cardCategory);
        stringBuilder.append(", ");
        stringBuilder.append(value);

        return stringBuilder;
    }

    public int getCleavageValue(Card card) {
        int cleavageValue = 0;
        switch (card.getCleavage()) {
            case "none":
                cleavageValue = 1;
                break;
            case "poor/none":
                cleavageValue = 2;
                break;
            case "1 poor":
                cleavageValue = 3;
                break;
            case "2 poor":
                cleavageValue = 4;
                break;
            case "1 good":
                cleavageValue = 5;
                break;
            case "1 good, 1 poor":
                cleavageValue = 6;
                break;
            case "2 good":
                cleavageValue = 7;
                break;
            case "3 good":
                cleavageValue = 8;
                break;
            case "1 perfect":
                cleavageValue = 9;
                break;
            case "1 perfect, 1 good":
                cleavageValue = 10;
                break;
            case "1 perfect, 2 good":
                cleavageValue = 11;
                break;
            case "2 perfect, 1 good":
                cleavageValue = 12;
                break;
            case "3 perfect":
                cleavageValue = 13;
                break;
            case "4 perfect":
                cleavageValue = 14;
                break;
            case "6 perfect":
                cleavageValue = 15;
        }
        return cleavageValue;
    }

    public boolean checkCard(Card selectedCard) {
        Card lastCardPlayed;
        if (playDeck.deckSize == 0 || newCategorySelected) {
            return true;
        } else {
            lastCardPlayed = playDeck.deck.get(playDeck.getDeckSize() - 1);
        }

        switch (cardCategory) {
            case "hardness":
                String[] lastHardness;
                String[] selectedHardness;
                double lastHardnessNumber;
                double selectedHardnessNumber;
                lastHardness = lastCardPlayed.getHardness().split("-");
                selectedHardness = selectedCard.getHardness().split("-");
                lastHardnessNumber = Double.parseDouble(lastHardness[lastHardness.length - 1]);
                selectedHardnessNumber = Double.parseDouble(selectedHardness[selectedHardness.length - 1]);
                return lastHardnessNumber < selectedHardnessNumber;


            case "specific gravity":
                String[] lastSpecificGravity;
                String[] selectedSpecificGravity;
                double lastSpecificGravityNumber;
                double selectedSpecificGravityNumber;
                lastSpecificGravity = lastCardPlayed.getSpecificGravity().split("-");
                selectedSpecificGravity = selectedCard.getSpecificGravity().split("-");
                lastSpecificGravityNumber = Double.parseDouble(lastSpecificGravity[lastSpecificGravity.length - 1]);
                selectedSpecificGravityNumber = Double.parseDouble(selectedSpecificGravity[selectedSpecificGravity.length - 1]);
                return lastSpecificGravityNumber < selectedSpecificGravityNumber;

            case "cleavage":
                int lastCleavage = getCleavageValue(lastCardPlayed);
                int selectedCleavage = getCleavageValue(selectedCard);
                return selectedCleavage > lastCleavage;

            case "crustal abundance":
                if (lastCardPlayed.getCrustalAbundance().equals(selectedCard.getCrustalAbundance())) {
                    return false;
                } else if (lastCardPlayed.getCrustalAbundance().equals("ultratrace")) {
                    return true;
                } else if (lastCardPlayed.getCrustalAbundance().equals("trace") && selectedCard.getCrustalAbundance().equals("ultratrace")) {
                    return false;
                } else if (lastCardPlayed.getCrustalAbundance().equals("low") && (selectedCard.getCrustalAbundance().equals("ultratrace") || selectedCard.getCrustalAbundance().equals("trace"))) {
                    return false;
                } else if (lastCardPlayed.getCrustalAbundance().equals("moderate") && (selectedCard.getCrustalAbundance().equals("ultratrace") || selectedCard.getCrustalAbundance().equals("trace") || selectedCard.getCrustalAbundance().equals("low"))) {
                    return false;
                } else if (lastCardPlayed.getCrustalAbundance().equals("high") && (selectedCard.getCrustalAbundance().equals("ultratrace") || selectedCard.getCrustalAbundance().equals("trace") || selectedCard.getCrustalAbundance().equals("low") || selectedCard.getCrustalAbundance().equals("moderate"))) {
                    return false;
                }
                return lastCardPlayed.getCrustalAbundance().equals("very high");

            case "economic value":
                if (lastCardPlayed.getEconomicValue().equals(selectedCard.getEconomicValue())) {
                    return false;
                } else if (lastCardPlayed.getEconomicValue().equals("trivial")) {
                    return true;
                } else if (lastCardPlayed.getEconomicValue().equals("low") && selectedCard.getEconomicValue().equals("trivial")) {
                    return false;
                } else if (lastCardPlayed.getEconomicValue().equals("moderate") && (selectedCard.getEconomicValue().equals("trivial") || selectedCard.getEconomicValue().equals("low"))) {
                    return false;
                } else if (lastCardPlayed.getEconomicValue().equals("high") && (selectedCard.getEconomicValue().equals("trivial") || selectedCard.getEconomicValue().equals("low") || selectedCard.getEconomicValue().equals("moderate"))) {
                    return false;
                } else if (lastCardPlayed.getEconomicValue().equals("very high") && (selectedCard.getEconomicValue().equals("trivial") || selectedCard.getEconomicValue().equals("low") || selectedCard.getEconomicValue().equals("moderate") || selectedCard.getEconomicValue().equals("high"))) {
                    return false;
                }
                return lastCardPlayed.getEconomicValue().equals("I'm rich!");
        }
        return false;
    }

    public void playCard(Card selectedCard, int cardChoice) {
        playDeck.addCard(selectedCard);
        players.get(playersTurn).getPlayersHand().remove(cardChoice);
        players.get(playersTurn).setHandSize(false);
        players.get(playersTurn).setPassed(false);
    }

    public void winningPlayer(){
        winningPlayers.add(players.get(playersTurn));
        players.remove(players.get(playersTurn));
    }

}
