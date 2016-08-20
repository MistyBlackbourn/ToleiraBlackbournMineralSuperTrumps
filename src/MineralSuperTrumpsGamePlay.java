import java.util.InputMismatchException;
import java.util.Scanner;

public class MineralSuperTrumpsGamePlay {
    public static void main(String[] args) {
        String playerName;
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

        Scanner userInput = new Scanner(System.in);
        for(int i = 0; i < numberPlayers; ++i) {
            System.out.print("Please enter the name of player" + (i + 1) + ": ");
            playerName = userInput.next();
            System.out.println("Player" + (i + 1) + "'s name is " + playerName);
        }

    }
}
