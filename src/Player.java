
public class Player {
    String playerName;
    int handSize = 8;
    Card[] playersHand = new Card[60]; //must test this when Card class is created

    Player(String newName) {
        playerName = newName;

    }

    public static void main(String[] args) {
        Player player1 = new Player("Toleira");
        System.out.println(player1.getName());
        System.out.println("Initial hand size " + player1.getHandSize());
        player1.setHandSize(true);
        System.out.println("Got a card " + player1.getHandSize());
        player1.setHandSize(false);
        System.out.println("Played a card " + player1.getHandSize());
        Player player2 = new Player("Royce");
        System.out.println(player2.getName());
        System.out.println(player2.getHandSize());


    }

    public String getName() {
        return this.playerName;
    }

    public void setHandSize(Boolean control) {
        if (control) {
            ++handSize;
        } else {
            --handSize;
        }
    }

    public int getHandSize() {
        return this.handSize;
    }
}
