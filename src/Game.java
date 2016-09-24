import com.dd.plist.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    Deck cardDeck = new Deck();
    Deck ruleDeck = new Deck();
    Deck playedDeck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> winningPlayers = new ArrayList<>();
    String cardCategory;
    boolean categoryIsSelected = false;
    boolean newCategorySelected = false;
    int playersTurn = 0;


    //Takes in a players name and creates a Player object
    public void createPlayers(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    //Reads the plist file and creates instances of cards depending on the card type and adds them to their respective decks
    public void createCards() {
        Card new_card;
        try {
            File file = new File(".idea/MstCards.plist");
            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
            NSObject[] cards = ((NSArray) rootDict.objectForKey("cards")).getArray();
            for (NSObject card : cards) {
                NSDictionary cardDictionary = (NSDictionary) card;
                if (cardDictionary.containsValue("play")) {
                    new_card = new PlayCard(cardDictionary.objectForKey("title").toString(), cardDictionary.objectForKey("card_type").toString(), cardDictionary.objectForKey("chemistry").toString(), cardDictionary.objectForKey("classification").toString(), cardDictionary.objectForKey("crystal_system").toString(), (NSArray) cardDictionary.objectForKey("occurrence"), cardDictionary.objectForKey("hardness").toString(), cardDictionary.objectForKey("specific_gravity").toString(), cardDictionary.objectForKey("cleavage").toString(), cardDictionary.objectForKey("crustal_abundance").toString(), cardDictionary.objectForKey("economic_value").toString());
                    cardDeck.addCard(new_card);
                } else if (cardDictionary.containsValue("trump")) {
                    new_card = new TrumpCard(cardDictionary.objectForKey("title").toString(), cardDictionary.objectForKey("card_type").toString(), cardDictionary.objectForKey("subtitle").toString());
                    cardDeck.addCard(new_card);
                } else if (cardDictionary.containsValue("rule")) {
                    new_card = new RuleCard(cardDictionary.objectForKey("title").toString(), cardDictionary.objectForKey("card_type").toString(), cardDictionary.objectForKey("subtitle").toString());
                    ruleDeck.addCard(new_card);
                } else {
                    System.out.println("Problem with Card");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Checks if each player has passed and returns true if all but one player has passed
    public boolean playersPassed() {
        int count = 0;
        for (Player player : players) {
            if (player.getPassed()) {
                ++count;
            }
        }
        return count >= (players.size() - 1);

    }

    //Shuffles the card deck
    public void shuffleDeck() {
        Collections.shuffle(cardDeck.deck);
    }

    // randomly selects a dealer and sets the player that goes first
    // Dealer deals card starting with the next player until all players have 8 cards
    public void dealCards() {
        int dealer;
        Random random = new Random();
        dealer = random.nextInt(players.size());

        for (int i = 0; i < 8; ++i) {
            int cardsDealt = 0;
            for (playersTurn = dealer + 1; cardsDealt < players.size(); ++playersTurn) {
                if (playersTurn >= players.size() && cardsDealt < players.size()) {
                    playersTurn = 0;
                }
                players.get(playersTurn).getPlayersHand().add(cardDeck.deck.get(cardDeck.getDeckSize() - 1));
                cardDeck.takeCard();
                ++cardsDealt;
            }

        }
    }

    //ensures that the next player is valid or loops the player turn back to the beginning
    public void validPlayer() {
        if (playersTurn >= players.size()) {
            playersTurn = 0;
        }
    }

    //increments to move play to the next player and keeps track of who's turn it is
    public void nextPlayer() {
        if (playersTurn >= players.size()) {
            playersTurn = 0;
        } else {
            ++playersTurn;
        }

    }

    //takes a card from the play deck and adds it to the players hand incrementing their hand size
    //sets that this player has passed this turn
    public void drawCard() {
        if (cardDeck.deckSize != 0) {
            players.get(playersTurn).getPlayersHand().add(cardDeck.deck.get(cardDeck.deckSize - 1));
            players.get(playersTurn).setHandSize(true);
            cardDeck.takeCard();
        }
        players.get(playersTurn).setPassed(true);
    }

    //when a new category is selected, all players are reset to not passed this turn
    public void resetPlayersPassed() {
        for (Player player : players) {
            player.setPassed(false);

        }
    }

    //Gets all the information of each card in their hand and adds it to a string builder
    public StringBuilder getPlayerCards(ArrayList<Card> playersHand) {
        StringBuilder stringBuilder = new StringBuilder();
        int cardNumber = 0;
        for (Card card : playersHand) {
            if (card.getCardType().equals("trump")) {
                stringBuilder.append(cardNumber + 1);
                stringBuilder.append(" | ");
                stringBuilder.append(card.getCardType());
                stringBuilder.append(" | ");
                stringBuilder.append(card.getTitle());
                stringBuilder.append(" | ");
                stringBuilder.append(card.getSubtitle());
                stringBuilder.append("\n");
                stringBuilder.append("\n");
            } else {
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
                for (int i = 0; i <= card.getOccurrence().indexOfObject(card.getOccurrence().lastObject()); i++) {
                    stringBuilder.append(card.getOccurrence().objectAtIndex(i).toString());
                    stringBuilder.append("  ");
                }
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
            }
            ++cardNumber;
        }
        stringBuilder.append(0);
        stringBuilder.append(" | ");
        stringBuilder.append("PASS");

        return stringBuilder;

    }

    //Saves the card selected and the information of the card to a string builder
    public StringBuilder playerSelection() {
        String value = "";
        Card lastCardPlayed = getLastCardPlayed();
        StringBuilder stringBuilder = new StringBuilder();

        if (lastCardPlayed.getCardType().equals("trump")) {
            stringBuilder.append(lastCardPlayed.getTitle());
            stringBuilder.append(", ");
            stringBuilder.append(lastCardPlayed.getSubtitle());
        } else {
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


            stringBuilder.append(lastCardPlayed.getTitle());
            stringBuilder.append(", ");
            stringBuilder.append(cardCategory);
            stringBuilder.append(", ");
            stringBuilder.append(value);
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }

    //Game rules are saved in a string builder
    public StringBuilder getRules() {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append("Mineral Supertrumps if a game designed to help players learn about the properties and uses\n" +
                "of common rockforming minerals. The pack consists of 54 mineral cards, and 6 'supertrump' cards. Each\n" +
                "mineral card includes information about the mineral such as the generic chemical formula, the classification, \n" +
                "crystal system, the geological environment where the mineral is commonly found or formed (igneous, metamorphic, \n" +
                "sedimentary or the mantle), as well as information in the five playing categories (or trumps) of Hardness, \n" +
                "Specific Gravity, Cleavage, Crustal Abundance, and Economic Value. The first three playing categories relate \n" +
                "to distinct physical properties of the mineral, while the last two categories rare the importance of the \n" +
                "mineral in terms of abundance in the Earths crust (continental and oceanic) and value to modern societies.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Number of players: 3 to 5");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Objective: To be the first player to lose all of your cards");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("How to play:");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("1. A Dealer (randomly chosen) shuffles the cards and deals each player 8 cards. Each player \n" +
                "can look at their cards, but should not show them to other players. The remaining card pack is placed face \n" +
                "down on the table.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("2. The player to the left of the deal goes first by placing a mineral card on the table. The \n" +
                "player must state the mineral name, one of the five playing categories (i.e., either Hardness, Specific \n" +
                "Gravity, Cleavage, Crustal Abundance or Economic Value), and the top value of that category. For example, \n" +
                "a player placing the Glaucophane card may state 'Glaucophane, Specific Gravity, 3.2'.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("3. The player next to the left takes the next turn. This player must play a mineral card \n" +
                "that has a higher value in the playing category than the card played by the previous player. For example, \n" +
                "of the Glaucophane card above, the player must place a card that has a value for specific gravity above \n" +
                "3.2. The player must state the mineral name and value of the category when playing their card. The game \n" +
                "continues with the next player to the left, and so on.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("4. If a player does not have any mineral cards that are of higher value for the specific \n" +
                "category or trump being played, then the player must pass and pick up one card from the card pack on the table. \n" +
                "The player then cannot play again until all but one player has passed, or until another player throws a \n" +
                "supertrump card to change the trump category, as described below. A player is allowed to pass even if they still \n" +
                "hold cards that could be played.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("5. If the player has a supertrump card (The Mineralogist, The Geologist, The Geophysicist, \n" +
                "The Petrologist, The Miner, The Gemmologist) they may play this card at any of their turns. By placing a \n" +
                "supertrump card, the player changes the playing category or trump according to the instructions on the \n" +
                "supertrump card. At this stage, any player who has passed on this previous round, is now able to play again. \n" +
                "If a player throws The Geophysicist card together with the Magnetite card, then that player wins the hand.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("6. The game continues with the players taking turns to play cards until all but on player has passed. \n" +
                "The last player then gets to lead out the next round and chooses the trump category to be played.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("7. The winner of the game is the first player to lose all of their cards. The game continues \n" +
                "until all but one player (i.e., the loser) has lose their cards.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Information on trump categories");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Hardness: relates to Moh's hardness scale of minerals from 1 to 10. Where a range of values \n" +
                "is presented the highest value should be used.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Specific Gravity: in grams per cubic cm. Where a range of values is presented the highest\n" +
                " value should be used.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Cleavage: refers to the number of cleavage planes and how well the places are typically expressed \n" +
                "in the crystal. For example, '1 perfect, 2 poor' means the mineral has 1 perfect cleavage plane, and 2 poor \n" +
                "cleavage planes. The order of ranking from lowest to highest is:");
        stringBuilder.append("\n");
        stringBuilder.append("none > poor/none > 1 poor > 2 poor > 1 good > 1 good, 1 poor > 2 good > 3 good > 1 perfect > \n" +
                "1 perfect, 1 good > 1 perfect, 2 good > 2 perfect, 1 good > 3 perfect > 4 perfect > 6 perfect.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Crustal abundance: is ranked from lowest to highest as:\n" +
                "ultratrace > trace > low > moderate > high > very high.");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Economic value: is ranked from lowest to highest as: \n" +
                "trvial > low > moderate > high > very high > I'm rich!");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Strategies:");
        stringBuilder.append("\n");
        stringBuilder.append("Like many card games, there are strategies that can increase the chance of winning. Obviously, \n" +
                "the more you can remember about the mineral cards the better, particularly if you can remember which cards \n" +
                "have been played already. The cards with high values in various trump categories and Supertrump cards should \n" +
                "used to try and win a hand, so use these wisely. When leading out a new round tru to being with a card that \n" +
                "tends to have low values for many categories; these cards are difficult to get rid of otherwise.");
        stringBuilder.append("\n");


        return stringBuilder;
    }

    //returns a number that represents the cleavage of a card
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

    //returns a number that represents the crustal abundance of a card
    public int getCrustalAbundanceValue(Card card) {
        int crustalAbundanceValue = 0;
        switch (card.getCrustalAbundance()) {
            case "ultratrace":
                crustalAbundanceValue = 1;
                break;
            case "trace":
                crustalAbundanceValue = 2;
                break;
            case "low":
                crustalAbundanceValue = 3;
                break;
            case "moderate":
                crustalAbundanceValue = 4;
                break;
            case "high":
                crustalAbundanceValue = 5;
                break;
            case "very high":
                crustalAbundanceValue = 6;
                break;
        }
        return crustalAbundanceValue;
    }

    //returns a number that represents the economic value of a card
    public int getEconomicValueValue(Card card) {
        int economicValueValue = 0;
        switch (card.getEconomicValue()) {
            case "trivial":
                economicValueValue = 1;
                break;
            case "low":
                economicValueValue = 2;
                break;
            case "moderate":
                economicValueValue = 3;
                break;
            case "high":
                economicValueValue = 4;
                break;
            case "very high":
                economicValueValue = 5;
                break;
            case "I'm rich!":
                economicValueValue = 6;
                break;
        }
        return economicValueValue;
    }

    public boolean specialRoundWinningCondition() {
        try {
            Card lastCardPlayed = getLastCardPlayed();
            Card secondLastCardPlayed = playedDeck.deck.get(playedDeck.getDeckSize() - 2);

            return lastCardPlayed.getTitle().equals("Magnetite") && secondLastCardPlayed.getTitle().equals("The Geophysicist");
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    //checks whether the card that has been selected can validly be played
    //if the deck is currently empty, the category has just been changed, or this card or the last card is a trump card, the card is automatically valid
    //each time a card is checked, it is based on the category that is currently selected
    public boolean checkCard(Card selectedCard) {
        Card lastCardPlayed;
        if (playedDeck.deckSize == 0 || newCategorySelected) {
            return true;
        } else {
            lastCardPlayed = getLastCardPlayed();
        }


        if (selectedCard.getCardType().equals("trump") || lastCardPlayed.getCardType().equals("trump")) {
            return true;
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
                return lastCleavage < selectedCleavage;

            case "crustal abundance":
                int lastCrustalAbundance = getCrustalAbundanceValue(lastCardPlayed);
                int selectedCrustalAbundance = getCrustalAbundanceValue(selectedCard);
                return lastCrustalAbundance < selectedCrustalAbundance;

            case "economic value":
                int lastEconomicValue = getEconomicValueValue(lastCardPlayed);
                int selectedEconomicValue = getEconomicValueValue(selectedCard);
                return lastEconomicValue < selectedEconomicValue;
        }
        return false;
    }

    //each time a card is played, the card is added to the play deck, removed from the players hand and their hand size is decremented
    //the player is also set to not passed this turn
    public void playCard(Card selectedCard, int cardChoice) {
        playedDeck.addCard(selectedCard);
        players.get(playersTurn).getPlayersHand().remove(cardChoice);
        players.get(playersTurn).setHandSize(false);
        players.get(playersTurn).setPassed(false);
    }

    //a player with an empty hand is added to the winning players array and removed from players array
    public void winningPlayer() {
        winningPlayers.add(players.get(playersTurn));
        players.remove(players.get(playersTurn));
    }

    //returns the card that was last played
    public Card getLastCardPlayed() {
        return playedDeck.deck.get(playedDeck.getDeckSize() - 1);
    }

    //returns the winning players in order from 1st to last
    public StringBuilder displayWinners(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("The winner ");
        for (Player player: winningPlayers) {
            stringBuilder.append("is: ");
            stringBuilder.append(player.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Following ");
        }

        stringBuilder.append("Last is: ");
        stringBuilder.append(players.get(0).getName());
        stringBuilder.append("\n");

        return stringBuilder;
    }

}
