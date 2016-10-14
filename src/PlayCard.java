import com.dd.plist.NSArray;

public class PlayCard extends Card {
    private String chemistry;
    private String classification;
    private String crystalSystem;
    private NSArray occurrence;
    private String hardness;
    private String specificGravity;
    private String cleavage;
    private String crustalAbundance;
    private String economicValue;


    PlayCard(String title, String cardType, String chemistry, String classification, String crystalSystem, NSArray occurrence,
             String hardness, String specificGravity, String cleavage, String crustalAbundance, String economicValue) {
        super(cardType, title);
        this.chemistry = chemistry;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrence = occurrence;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
    }

    //returns the chemistry
    public String getChemistry() {
        return this.chemistry;
    }

    //returns the classification
    public String getClassification() {
        return this.classification;
    }

    //returns the crystal system
    public String getCrystalSystem() {
        return this.crystalSystem;
    }

    //returns the hardness
    public String getHardness() {
        return this.hardness;
    }

    //returns the specific gravity
    public String getSpecificGravity() {
        return this.specificGravity;
    }

    //returns the cleavage
    public String getCleavage() {
        return this.cleavage;
    }

    //returns the crustal abundance
    public String getCrustalAbundance() {
        return this.crustalAbundance;
    }

    //returns the economic value
    public String getEconomicValue() {
        return this.economicValue;
    }

    //returns an array of the occurrences
    public NSArray getOccurrence() {
        return this.occurrence;
    }

    //returns null
    public String getSubtitle() {
        return null;
    }
}
