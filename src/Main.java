import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String playerName;
        int numberPlayers = 0;
        boolean winner = false;
        int cardChoice = 0;
        boolean validCard;
        boolean categorySelected = false;

        int menuSelection = 0;


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

                Scanner userInput = new Scanner(System.in);
                for (int i = 0; i < numberPlayers; ++i) {
                    System.out.print("Please enter the name of player" + (i + 1) + ": ");
                    playerName = userInput.next();
                    game.createPlayers(playerName);

                }
                game.createCards();
                game.shuffleDeck();
                game.dealCards();
                int i = 0;
                while (!winner) {
                    System.out.println(game.players.get(i).playerName);

                    System.out.println(game.getPlayerCards(game.players.get(i).playersHand));
                    validCard = false;
                    while (!validCard) {
                        do {
                            try {
                                System.out.println("Please enter the number for the corresponding card");
                                Scanner cardInput = new Scanner(System.in);
                                cardChoice = cardInput.nextInt();
                                if (!categorySelected) {
                                    System.out.println("Please select the category \n Hardness \n Specific Gravity \n Cleavage \n" +
                                            " Crustal Abundance \n Economic Value");
                                    game.cardCategory = userInput.next().toLowerCase();
                                    System.out.println(game.cardCategory);
                                    categorySelected = true;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid number");
                            }
                        } while (cardChoice > game.players.get(i).playersHand.size() || cardChoice < 0);
                        if (cardChoice == 0) {
                            //pass - player must take a card
                            System.out.println("Chose to pass, draw a card");
                            validCard = true;
                        } else {
                            validCard = game.checkCard(game.players.get(i).playersHand.get(cardChoice - 1));
                            game.playDeck.addCard(game.players.get(i).playersHand.get(cardChoice - 1));
                            if (!validCard) {
                                System.out.println("You can't play that card, please select another");
                            }
                        }
                    }
                    System.out.println("Worked!");
                    ++i;
                    if (i >= numberPlayers) {
                        winner = true; //This makes the loop not infinite during testing
                        i = 0;
                    }
                }
            } else if (menuSelection == 2) {
                System.out.println("THE RULES ARE...");
            }
        } while (menuSelection != 3);
        System.out.println("Thanks for playing!");
    }
}

