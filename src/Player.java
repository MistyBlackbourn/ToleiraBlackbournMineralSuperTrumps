
public class Player {
    String playerName;
    int handSize = 8;
    Card[] playersHand = new Card[60]; //must test this when Card class is created

    Player(String newName) {
        playerName = newName;

    }

    //setters

    public void setPlayersHand(Card[] newPlayersHand) {
        this.playersHand = newPlayersHand;
    }

    public void setPlayerName(String newPlayerName) {
        this.playerName = newPlayerName;
    }

    public void setHandSize(Boolean control) {
        if (control) {
            ++handSize;
        } else {
            --handSize;
        }
    }

    //getters

    public Card[] getPlayersHand() {
        return playersHand;
    }

    public String getName() {
        return this.playerName;
    }

    public int getHandSize() {
        return this.handSize;
    }
}
