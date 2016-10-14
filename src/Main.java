import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Game game = new Game();

    //displays the menu, if they choose to play game begins, if they choose to see the rules, they are displayed otherwise, program quits
    //gets the number of players then creates the players, creates the cards, shuffles the deck then deals.
    //game plays in the following order until all but one player has emptied their hand:
    //checks player is valid and has not passed
    //display players cards
    //asks for a selection
    //checks/gets the category
    //validates card
    //checks if they've won
    //moves to next player
    public static void main(String[] args) {
        int cardChoice;
        boolean validCard;
        int numberPlayers;
        int menuSelection;


        System.out.println("Welcome to Mineral Super Trumps");
        do {
            System.out.println("Please make a selection. \n(1) Play Game \n" +
                    "(2) See rules \n" +
                    "(3) Quit");
            menuSelection = getMenuSelection();

            if (menuSelection == 1) {
                numberPlayers = getPlayers();

                getPlayersNames(numberPlayers);
                game.createCards();
                game.shuffleDeck();
                game.dealCards();
                while (game.players.size() > 1) {
                    game.validPlayer();
                    if (!game.players.get(game.playersTurn).getPassed()) {
                        System.out.println(game.players.get(game.playersTurn).getName());

                        System.out.println(game.getPlayerCards(game.players.get(game.playersTurn).getPlayersHand()));
                        validCard = false;
                        while (!validCard) {
                            cardChoice = getCardSelection();
                            if (cardChoice == 0) {
                                System.out.println("Chose to pass, draw a card");
                                game.drawCard();
                                validCard = true;
                                if (game.playersPassed()) {
                                    game.categoryIsSelected = false;
                                }
                            } else {
                                validCard = game.checkCard(game.players.get(game.playersTurn).getPlayersHand().get(cardChoice - 1));
                                if (!validCard) {
                                    System.out.println("You can't play that card, please select another");
                                } else {
                                    game.playCard(game.players.get(game.playersTurn).getPlayersHand().get(cardChoice - 1), cardChoice - 1);
                                    game.newCategorySelected = false;
                                    System.out.println(game.playerSelection());
                                }
                            }
                        }
                        if (game.players.get(game.playersTurn).getHandSize() == 0) {
                            game.winningPlayer();

                        }
                        if (game.playedDeck.getDeckSize() != 0) {
                            if (!game.getLastCardPlayed().getCardType().equals("trump") && !game.specialRoundWinningCondition()) {
                                game.nextPlayer();
                            }
                        } else {
                            game.nextPlayer();
                        }
                    }
                    else {
                        game.nextPlayer();
                    }
                }
                System.out.println(game.displayWinners());

            } else if (menuSelection == 2) {
                displayRules();

            }
        } while (menuSelection != 3);
        System.out.println("Thanks for playing!");
    }

    //user enters a number to select which card they would like to play
    //then they may or may not be asked to select a category depending on their selection or if a category is not already selected
    public static int getCardSelection() {
        int choice;
        do {
            try {
                System.out.println("Please enter the number for the corresponding card");
                if (!game.categoryIsSelected) {
                    System.out.println("You may select any card and next you will need to select a new category");
                }
                Scanner cardInput = new Scanner(System.in);
                System.out.print(">>>");
                choice = cardInput.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                choice = -1;
            }
        } while (choice > game.players.get(game.playersTurn).getHandSize() || choice < 0);
        if (choice != 0) {
            if (!game.categoryIsSelected || game.players.get(game.playersTurn).getPlayersHand().get((choice - 1)).getCardType().equals("trump")) {
                setCategory(game.players.get(game.playersTurn).getPlayersHand().get(choice - 1));

            }
        }
        return choice;
    }

    //user enters a number to make a menu selection
    public static int getMenuSelection() {
        int input = 0;
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                System.out.print(">>>");
                input = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please make a valid selection");
            }

        } while (input < 1 || input > 3);
        return input;
    }

    //user enters how many players will be playing
    //they must select between 3 and 5 inclusive
    public static int getPlayers() {
        int numberPlayers = 0;
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                System.out.println("There must be at least 3 players and at most 5 players.");
                System.out.print("Please enter the number of players: ");
                numberPlayers = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");

            }
        } while (numberPlayers < 3 || numberPlayers > 5);
        return numberPlayers;
    }

    //user enters their name
    public static void getPlayersNames(int numberPlayers) {
        String playerName;
        Scanner userInput = new Scanner(System.in);

        for (int i = 0; i < numberPlayers; ++i) {
            System.out.print("Please enter the name of player" + (i + 1) + ": ");
            playerName = userInput.next();
            game.createPlayers(playerName);

        }

    }

    //depending on the card played, the category will be selected or will call getCategory so a category can be selected
    //it is set so that the category is currently selected and that a new category has just been selected
    //all players that had passed are now set to not passed
    public static void setCategory(Card playersChosenCard) {
        int selection;
        if (playersChosenCard.getCardType().equals("trump")) {
            String subtitle = playersChosenCard.getSubtitle();

            switch (subtitle) {
                case "Hardness":
                    selection = 1;
                    break;
                case "Specific gravity":
                    selection = 2;
                    break;
                case "Cleavage":
                    selection = 3;
                    break;
                case "Crustal abundance":
                    selection = 4;
                    break;
                case "Economic value":
                    selection = 5;
                    break;
                default:
                    selection = getCategory();
            }
        } else {
            selection = getCategory();
        }

        if (selection == 1) {
            game.cardCategory = "hardness";
        } else if (selection == 2) {
            game.cardCategory = "specific gravity";
        } else if (selection == 3) {
            game.cardCategory = "cleavage";
        } else if (selection == 4) {
            game.cardCategory = "crustal abundance";
        } else if (selection == 5) {
            game.cardCategory = "economic value";
        }
        game.categoryIsSelected = true;
        game.newCategorySelected = true;
        game.resetPlayersPassed();

    }

    //user is asked to select a category
    public static int getCategory() {
        int selection = 0;
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                System.out.println("Please select the category \n 1 - Hardness \n 2 - Specific Gravity \n 3 - Cleavage \n" +
                        " 4 - Crustal Abundance \n 5 - Economic Value");
                System.out.print(">>>");
                selection = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Selection is invalid");
            }
        } while (selection < 1 || selection > 5);
        return selection;
    }

    //displays the game rules
    public static void displayRules() {
        System.out.println(game.getRules());
    }

}

