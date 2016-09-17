public class Card {
    private String cardType;
    private String title;
    private String subtitle;
    private String chemistry;
    private String classification;
    private String crystalSystem;
    private String occurrence;
    private String hardness;
    private String specificGravity;
    private String cleavage;
    private String crustalAbundance;
    private String economicValue;

    Card(String cardType, String title, String subtitle) {
        this.cardType = cardType;
        this.title = title;
        this.subtitle = subtitle;
    }

    Card(String title, String cardType, String chemistry, String classification, String crystalSystem, String occurrence,
         String hardness, String specificGravity, String cleavage, String crustalAbundance, String economicValue) {
        this.cardType = cardType;
        this.title = title;
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

    //setters

    public void setCardType(String newCardType) {
        this.cardType = newCardType;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setSubtitle(String newSubtitle) {
        this.subtitle = newSubtitle;
    }

    public void setChemistry(String newChemistry) {
        this.chemistry = newChemistry;
    }

    public void setClassification(String newClassification) {
        this.classification = newClassification;
    }

    public void setCrystalSystem(String newCrystalSystem) {
        this.crystalSystem = newCrystalSystem;
    }

    public void setHardness(String newHardness) {
        this.hardness = newHardness;
    }

    public void setSpecificGravity(String newSpecificGravity) {
        this.specificGravity = newSpecificGravity;
    }

    public void setCleavage(String newCleavage) {
        this.cleavage = newCleavage;
    }

    public void setCrustalAbundance(String newCrustalAbundance) {
        this.crustalAbundance = newCrustalAbundance;
    }

    public void setEconomicValue(String newEconomicValue) {
        this.economicValue = newEconomicValue;
    }

    public void setOccurrence(String newOccurrence) {
        this.occurrence = newOccurrence;
    }

    //getters

    public String getCardType() {
        return this.cardType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getChemistry() {
        return this.chemistry;
    }

    public String getClassification() {
        return this.classification;
    }

    public String getCrystalSystem() {
        return this.crystalSystem;
    }

    public String getHardness() {
        return this.hardness;
    }

    public String getSpecificGravity() {
        return this.specificGravity;
    }

    public String getCleavage() {
        return this.cleavage;
    }

    public String getCrustalAbundance() {
        return this.crustalAbundance;
    }

    public String getEconomicValue() {
        return this.economicValue;
    }

    public String getOccurrence() {
        return this.occurrence;
    }
}
