import com.dd.plist.NSArray;

public abstract class Card {
    private String cardType;
    private String title;
    private String fileName;

    Card(String cardType, String title, String fileName) {
        this.cardType = cardType;
        this.title = title;
        this.fileName = fileName;
    }

    //returns the card type
    public String getCardType() {
        return cardType;
    }

    //returns the cards title
    public String getTitle() {
        return title;
    }

    //return the fileName of the image for the card
    public String getFileName() {
        return fileName;
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
