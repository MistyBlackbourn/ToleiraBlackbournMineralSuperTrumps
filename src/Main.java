import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Game game = new Game();

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
                //int i = 0;
                while (game.players.size() > 1) {
                    game.validPlayer();
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
                    if (!game.getLastCardPlayed().getCardType().equals("trump")) {
                        game.nextPlayer();
                    }
                }
            } else if (menuSelection == 2) {
                displayRules();

            }
        } while (menuSelection != 3);
        System.out.println("Thanks for playing!");
    }

    public static int getCardSelection() {
        int choice = 0;
        do {
            try {
                System.out.println("Please enter the number for the corresponding card");
                if (!game.categoryIsSelected) {
                    System.out.println("You may select any card and next you will need to select a new category");
                }
                Scanner cardInput = new Scanner(System.in);
                choice = cardInput.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        } while (choice > game.players.get(game.playersTurn).getHandSize() || choice < 0);
        if (!game.categoryIsSelected && choice != 0) {
            getCategory(game.players.get(game.playersTurn).getPlayersHand().get(choice-1));

        }
        return choice;
    }

    public static int getMenuSelection() {
        int input = 0;
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                input = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please make a valid selection");
            }

        } while (input < 1 || input > 3);
        return input;
    }

    public static int getPlayers() {
        Scanner userInput = new Scanner(System.in);
        int numberPlayers = 0;
        do {
            try {

                System.out.println("There must be at least 3 players and at most 5 players.");
                System.out.print("Please enter the number of players: ");
                numberPlayers = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");

            }
        } while (numberPlayers < 3 || numberPlayers > 5);
        return numberPlayers;
    }

    public static void getPlayersNames(int numberPlayers) {
        String playerName;
        Scanner userInput = new Scanner(System.in);

        for (int i = 0; i < numberPlayers; ++i) {
            System.out.print("Please enter the name of player" + (i + 1) + ": ");
            playerName = userInput.next();
            game.createPlayers(playerName);

        }

    }

    public static void getCategory(Card playersChosenCard) {
        int selection = 0;

        if (playersChosenCard.getCardType().equals("trump")) {
            String subtitle = playersChosenCard.getSubtitle();
            game.cardCategory = subtitle.toLowerCase();

        } else {

            do {
                try {
                    Scanner userInput = new Scanner(System.in);
                    System.out.println("Please select the category \n 1 - Hardness \n 2 - Specific Gravity \n 3 - Cleavage \n" +
                            " 4 - Crustal Abundance \n 5 - Economic Value");
                    selection = userInput.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Selection is invalid");
                }
            } while (selection < 1 || selection > 5);

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
        }
        game.categoryIsSelected = true;
        game.newCategorySelected = true;
        game.resetPlayersPassed();
    }

    public static void displayRules() {
        //use string builder in Game to get rules
        //return the String here to display
        System.out.println("THE RULES ARE...");
    }

}

