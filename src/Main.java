import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String playerName;
        int numberPlayers = 0;
        boolean winner = false;
        int cardChoice = 0;

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
            System.out.println(game.players.get(i));

            System.out.println(game.getPlayerCards(game.players.get(i).playersHand));
            do {
                try {
                    System.out.println("Please enter the number for the corresponding card");
                    cardChoice = userInput.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
            } while(cardChoice > game.players.get(i).playersHand.size() || cardChoice < 0);
            System.out.println("Worked!");
            ++i;
            if (i >= numberPlayers) {
                winner = true; //This makes the loop not infinite during testing
                i = 0;
            }
        }
    }
}
