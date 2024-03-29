import com.dd.plist.NSArray;

public class TrumpCard extends Card {
    private String subtitle;


    TrumpCard(String title, String cardType, String fileName, String subtitle) {
        super(cardType, title, fileName);
        this.subtitle = subtitle;
    }

    //returns the subtitle
    public String getSubtitle() {
        return this.subtitle;
    }

    //returns null
    public String getChemistry() {
        return null;
    }

    //returns null
    public String getClassification() {
        return null;
    }

    //returns null
    public String getCrystalSystem() {
        return null;
    }

    //returns null
    public String getHardness() {
        return null;
    }

    //returns null
    public String getSpecificGravity() {
        return null;
    }

    //returns null
    public String getCleavage() {
        return null;
    }

    //returns null
    public String getCrustalAbundance() {
        return null;
    }

    //returns null
    public String getEconomicValue() {
        return null;
    }

    //returns null
    public NSArray getOccurrence() {
        return null;
    }

}
