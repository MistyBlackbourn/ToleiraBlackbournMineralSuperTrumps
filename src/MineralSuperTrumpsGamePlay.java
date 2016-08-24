import java.util.InputMismatchException;
import java.util.Scanner;

public class MineralSuperTrumpsGamePlay {
    public static void main(String[] args) {
        String playerName;
        int numberPlayers = 0;
//for testing Card class. This needs to be changed to read xml file
        String[] array = new String[3];
        Card card1 = new Card("Quartz", "play", "SiO_2", "tectosilicate", "hexagonal", array, 7, 2.65, "poor/none", "high", "moderate");
        Card card2 = new Card("Plagioclase", "play", "Na Al Si_3 0_8-Ca Al_2 Si_2 0_8", "tectosilicate", "triclinic", array, 6-6.5, 2.6-2.8, "1 perfect. 1 good", "very high", "moderate");


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
