import java.util.ArrayList;

public class Player {
    private String playerName;
    private boolean passed = false;
    private int handSize = 8;
    private ArrayList<Card> playersHand = new ArrayList<>();

    Player(String newName) {
        playerName = newName;

    }

    //setters

    public void setPlayersHand(ArrayList<Card> newPlayersHand) {
        this.playersHand = newPlayersHand;
    }

    public void setPlayerName(String newPlayerName) {
        this.playerName = newPlayerName;
    }

    public void setHandSize(boolean control) {
        if (control) {
            ++handSize;
        } else {
            --handSize;
        }
    }

    public void setPassed(boolean passed){
        this.passed = passed;
    }

    //getters

    public ArrayList<Card> getPlayersHand() {
        return this.playersHand;
    }

    public String getName() {
        return this.playerName;
    }

    public int getHandSize() {
        return this.handSize;
    }

    public boolean getPassed(){
        return this.passed;
    }
}
