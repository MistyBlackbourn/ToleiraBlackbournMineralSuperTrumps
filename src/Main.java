import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Game game = new Game();

    public static void main(String[] args) {
        boolean winner = false;
        int cardChoice = 0;
        boolean validCard;
        boolean categorySelected = false;
        boolean newCategorySelected = false;
        int numberPlayers;
        int menuSelection = 0;
        int playersPassed = 0;


        System.out.println("Welcome to Mineral Super Trumps");
        do {
            System.out.println("Please make a selection. \n(1) Play Game \n" +
                    "(2) See rules \n" +
                    "(3) Quit");
            do {
                try {
                    Scanner userInput = new Scanner(System.in);
                    menuSelection = userInput.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please make a valid selection");
                }

            } while (menuSelection < 1 || menuSelection > 3);


            if (menuSelection == 1) {
                numberPlayers = getPlayers();

                getPlayersNames(numberPlayers);
                game.createCards();
                game.shuffleDeck();
                game.dealCards();
                //int i = 0;
                while (!winner) {
                    game.validPlayer();
                    System.out.println(game.players.get(game.playersTurn).playerName);

                    System.out.println(game.getPlayerCards(game.players.get(game.playersTurn).playersHand));
                    validCard = false;
                    while (!validCard) {
                        do {
                            try {
                                System.out.println("Please enter the number for the corresponding card");
                                if (!categorySelected){
                                    System.out.println("If you select a card, you will also need to select a category");
                                }
                                Scanner cardInput = new Scanner(System.in);
                                cardChoice = cardInput.nextInt();
                                newCategorySelected = false;
                                if (!categorySelected && !game.players.get(game.playersTurn).passed) {
                                    getCategory();
                                    categorySelected = true;
                                    newCategorySelected = true;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid number");
                            }
                        } while (cardChoice > game.players.get(game.playersTurn).playersHand.size() || cardChoice < 0);
                        if (cardChoice == 0) {
                            System.out.println("Chose to pass, draw a card");
                            game.drawCard();
                            validCard = true;
                            ++playersPassed;
                            if (playersPassed >= numberPlayers-1) {
                                categorySelected = false;
                            }
                        } else {
                            validCard = game.checkCard(game.players.get(game.playersTurn).playersHand.get(cardChoice - 1), newCategorySelected);
                            //game.playDeck.addCard(game.players.get(game.playersTurn).playersHand.get(cardChoice - 1));
                            if (!validCard) {
                                System.out.println("You can't play that card, please select another");
                            } else {
                                game.playCard(game.players.get(game.playersTurn).playersHand.get(cardChoice - 1), cardChoice - 1);
                                System.out.println(game.playerSelection());
                            }
                        }
                    }
                    //System.out.println("Worked!");

                    game.nextPlayer();
                    if (game.playersTurn >= numberPlayers) {
                        winner = true; //This makes the loop not infinite during testing

                    }
                }
            } else if (menuSelection == 2) {
                displayRules();

            }
        } while (menuSelection != 3);
        System.out.println("Thanks for playing!");
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

    public static void getCategory() {
        //Add error checking
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select the category \n Hardness \n Specific Gravity \n Cleavage \n" +
                " Crustal Abundance \n Economic Value");
        game.cardCategory = userInput.nextLine();
        game.cardCategory = game.cardCategory.toLowerCase();
        //System.out.println(game.cardCategory);
    }

    public static void displayRules() {
        //use string builder in Game to get rules
        //return the String here to display
        System.out.println("THE RULES ARE...");
    }

}

