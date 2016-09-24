import com.dd.plist.NSArray;

public abstract class Card {
    private String cardType;
    private String title;

    Card(String cardType, String title) {
        this.cardType = cardType;
        this.title = title;
    }

    //returns the card type
    public String getCardType() {
        return cardType;
    }

    //returns the cards title
    public String getTitle() {
        return title;
    }


    public abstract String getSubtitle();

    public abstract String getChemistry();

    public abstract String getClassification();

    public abstract String getCrystalSystem();

    public abstract String getHardness();

    public abstract String getSpecificGravity();

    public abstract String getCleavage();

    public abstract String getCrustalAbundance();

    public abstract String getEconomicValue();

    public abstract NSArray getOccurrence();
}
