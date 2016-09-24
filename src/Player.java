import java.util.ArrayList;

public class Player {
    private String playerName;
    private boolean passed = false;
    private int handSize = 8;
    private ArrayList<Card> playersHand = new ArrayList<>();

    Player(String newName) {
        playerName = newName;

    }

    //increments or decrements the hand size depending on the control
    public void setHandSize(boolean control) {
        if (control) {
            ++handSize;
        } else {
            --handSize;
        }
    }

    //set whether the player has passed this round or not
    public void setPassed(boolean passed){
        this.passed = passed;
    }

    //returns the cards the player has in their hand
    public ArrayList<Card> getPlayersHand() {
        return this.playersHand;
    }

    //return the players name
    public String getName() {
        return this.playerName;
    }

    //returns the hand size
    public int getHandSize() {
        return this.handSize;
    }

    //returns whether the player has passed or not
    public boolean getPassed(){
        return this.passed;
    }
}
