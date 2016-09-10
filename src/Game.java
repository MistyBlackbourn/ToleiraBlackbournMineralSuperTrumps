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

    public void shuffleDeck() {
        Collections.shuffle(cardDeck.deck);
    }

    // randomly selects a dealer and sets the which player goes first
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
                players.get(playersTurn).playersHand.add(cardDeck.deck.get(i));
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
        players.get(playersTurn).playersHand.add(cardDeck.deck.get(cardDeck.deckSize - 1));
        players.get(playersTurn).setHandSize(true);
        players.get(playersTurn).setPassed(true);
        cardDeck.takeCard();
    }

    public void resetPlayersPassed(){
        for (Player player: players) {
            player.setPassed(false);
            System.out.println(player.passed);

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
            stringBuilder.append(card.crystalSystem);
            stringBuilder.append(" | ");
            stringBuilder.append(card.occurrence);
            stringBuilder.append("\n");
            stringBuilder.append("Hardness: ");
            stringBuilder.append(card.hardness);
            stringBuilder.append("\n");
            stringBuilder.append("Specific Gravity: ");
            stringBuilder.append(card.specificGravity);
            stringBuilder.append("\n");
            stringBuilder.append("Cleavage: ");
            stringBuilder.append(card.cleavage);
            stringBuilder.append("\n");
            stringBuilder.append("Crustal Abundance: ");
            stringBuilder.append(card.crustalAbundance);
            stringBuilder.append("\n");
            stringBuilder.append("Economic Value: ");
            stringBuilder.append(card.economicValue);
            stringBuilder.append("\n");
            stringBuilder.append("\n");
            ++cardNumber;
        }
        stringBuilder.append(0);
        stringBuilder.append(" | ");
        stringBuilder.append("PASS");

        return stringBuilder;

    }

    public StringBuilder playerSelection(){
        String value = "";
        Card lastCardPlayed = playDeck.deck.get(playDeck.getDeckSize() - 1);

        switch(cardCategory){
            case "hardness":
                String[] lastHardness;
                lastHardness = lastCardPlayed.hardness.split("-");
                value = lastHardness[lastHardness.length - 1];
                break;
            case "specific gravity":
                String[] lastSpecificGravity;
                lastSpecificGravity = lastCardPlayed.hardness.split("-");
                value = lastSpecificGravity[lastSpecificGravity.length - 1];
                break;
            case "cleavage":
                value = lastCardPlayed.cleavage;
                break;
            case "crustal abundance":
                value = lastCardPlayed.crustalAbundance;
                break;
            case "economic value":
                value = lastCardPlayed.economicValue;
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lastCardPlayed.title);
        stringBuilder.append(", ");
        stringBuilder.append(cardCategory);
        stringBuilder.append(", ");
        stringBuilder.append(value);

        return stringBuilder;
    }

    public boolean checkCard(Card selectedCard, boolean newCategorySelected) {
        boolean validCard = false;
        Card lastCardPlayed;
        if (playDeck.deckSize == 0 || newCategorySelected) {
            return true;
        } else {
            lastCardPlayed = playDeck.deck.get(playDeck.getDeckSize() - 1); // will be used for comparisons
        }

        //each switch case must compare the cardCategory of selectedCard with the lastCardPlayed

        switch (cardCategory) {
            case "hardness":
                String[] lastHardness;
                String[] selectedHardness;
                double lastHardnessNumber;
                double selectedHardnessNumber;
                lastHardness = lastCardPlayed.hardness.split("-");
                selectedHardness = selectedCard.hardness.split("-");
                lastHardnessNumber = Double.parseDouble(lastHardness[lastHardness.length - 1]);
                selectedHardnessNumber = Double.parseDouble(selectedHardness[selectedHardness.length - 1]);
                //System.out.println(lastHardnessNumber);
                //System.out.println(selectedHardnessNumber);
                return lastHardnessNumber < selectedHardnessNumber;


            case "specific gravity":
                String[] lastSpecificGravity;
                String[] selectedSpecificGravity;
                double lastSpecificGravityNumber;
                double selectedSpecificGravityNumber;
                lastSpecificGravity = lastCardPlayed.specificGravity.split("-");
                selectedSpecificGravity = selectedCard.specificGravity.split("-");
                lastSpecificGravityNumber = Double.parseDouble(lastSpecificGravity[lastSpecificGravity.length - 1]);
                selectedSpecificGravityNumber = Double.parseDouble(selectedSpecificGravity[selectedSpecificGravity.length - 1]);
                //System.out.println(lastSpecificGravityNumber);
                //System.out.println(selectedSpecificGravityNumber);
                return lastSpecificGravityNumber < selectedSpecificGravityNumber;

            case "cleavage":
                int lastCleavage = 0;
                int selectedCleavage = 0;

                switch (lastCardPlayed.cleavage) {
                    case "none":
                        lastCleavage = 1;
                        break;
                    case "poor/none":
                        lastCleavage = 2;
                        break;
                    case "1 poor":
                        lastCleavage = 3;
                        break;
                    case "2 poor":
                        lastCleavage = 4;
                        break;
                    case "1 good":
                        lastCleavage = 5;
                        break;
                    case "1 good, 1 poor":
                        lastCleavage = 6;
                        break;
                    case "2 good":
                        lastCleavage = 7;
                        break;
                    case "3 good":
                        lastCleavage = 8;
                        break;
                    case "1 perfect":
                        lastCleavage = 9;
                        break;
                    case "1 perfect, 1 good":
                        lastCleavage = 10;
                        break;
                    case "1 perfect, 2 good":
                        lastCleavage = 11;
                        break;
                    case "2 perfect, 1 good":
                        lastCleavage = 12;
                        break;
                    case "3 perfect":
                        lastCleavage = 13;
                        break;
                    case "4 perfect":
                        lastCleavage = 14;
                        break;
                    case "6 perfect":
                        lastCleavage = 15;
                }

                switch (selectedCard.cleavage) {
                    case "none":
                        selectedCleavage = 1;
                        break;
                    case "poor/none":
                        selectedCleavage = 2;
                        break;
                    case "1 poor":
                        selectedCleavage = 3;
                        break;
                    case "2 poor":
                        selectedCleavage = 4;
                        break;
                    case "1 good":
                        selectedCleavage = 5;
                        break;
                    case "1 good, 1 poor":
                        selectedCleavage = 6;
                        break;
                    case "2 good":
                        selectedCleavage = 7;
                        break;
                    case "3 good":
                        selectedCleavage = 8;
                        break;
                    case "1 perfect":
                        selectedCleavage = 9;
                        break;
                    case "1 perfect, 1 good":
                        selectedCleavage = 10;
                        break;
                    case "1 perfect, 2 good":
                        selectedCleavage = 11;
                        break;
                    case "2 perfect, 1 good":
                        selectedCleavage = 12;
                        break;
                    case "3 perfect":
                        selectedCleavage = 13;
                        break;
                    case "4 perfect":
                        selectedCleavage = 14;
                        break;
                    case "6 perfect":
                        selectedCleavage = 15;
                }
                return selectedCleavage > lastCleavage;

            case "crustal abundance":
                if (lastCardPlayed.crustalAbundance.equals(selectedCard.crustalAbundance)) {
                    return false;
                } else if (lastCardPlayed.crustalAbundance.equals("ultratrace")) {
                    return true;
                } else if (lastCardPlayed.crustalAbundance.equals("trace") && selectedCard.crustalAbundance.equals("ultratrace")) {
                    return false;
                } else if (lastCardPlayed.crustalAbundance.equals("low") && (selectedCard.crustalAbundance.equals("ultratrace") || selectedCard.crustalAbundance.equals("trace"))) {
                    return false;
                } else if (lastCardPlayed.crustalAbundance.equals("moderate") && (selectedCard.crustalAbundance.equals("ultratrace") || selectedCard.crustalAbundance.equals("trace") || selectedCard.crustalAbundance.equals("low"))) {
                    return false;
                } else if (lastCardPlayed.crustalAbundance.equals("high") && (selectedCard.crustalAbundance.equals("ultratrace") || selectedCard.crustalAbundance.equals("trace") || selectedCard.crustalAbundance.equals("low") || selectedCard.crustalAbundance.equals("moderate"))) {
                    return false;
                }
                return lastCardPlayed.crustalAbundance.equals("very high");

            case "economic value":
                if (lastCardPlayed.economicValue.equals(selectedCard.economicValue)) {
                    return false;
                } else if (lastCardPlayed.economicValue.equals("trivial")) {
                    return true;
                } else if (lastCardPlayed.economicValue.equals("low") && selectedCard.economicValue.equals("trivial")) {
                    return false;
                } else if (lastCardPlayed.economicValue.equals("moderate") && (selectedCard.economicValue.equals("trivial") || selectedCard.economicValue.equals("low"))) {
                    return false;
                } else if (lastCardPlayed.economicValue.equals("high") && (selectedCard.economicValue.equals("trivial") || selectedCard.economicValue.equals("low") || selectedCard.economicValue.equals("moderate"))) {
                    return false;
                } else if (lastCardPlayed.economicValue.equals("very high") && (selectedCard.economicValue.equals("trivial") || selectedCard.economicValue.equals("low") || selectedCard.economicValue.equals("moderate") || selectedCard.economicValue.equals("high"))) {
                    return false;
                }
                return lastCardPlayed.economicValue.equals("I'm rich!");
        }
        return validCard;
    }

    public void playCard(Card selectedCard, int cardChoice) {
        playDeck.addCard(selectedCard);
        players.get(playersTurn).playersHand.remove(cardChoice);
        players.get(playersTurn).setPassed(false);
        //System.out.println(cardDeck.deck.get(cardDeck.getDeckSize()-1).title);
    }

}
