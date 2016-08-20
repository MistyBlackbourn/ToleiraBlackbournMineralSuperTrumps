public class Card {
    String cardType;
    String title;
    String subtitle;
    String chemistry;
    String classification;
    String crystalSystem;
    String[] occurrence = new String[3];
    double hardness;
    double specificGravity;
    String cleavage;
    String crustalAbundance;
    String economicValue;

    Card(String subtitle) {
        this.subtitle = subtitle;
    }

    Card(String chemistry, String classification, String crystalSystem, String[] occurrence,
         double hardness, double specificGravity, String cleavage, String crustalAbundance, String economicValue) {
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

    public void setHardness(double newHrdness) {
        this.hardness = newHrdness;
    }

    public void setSpecificGravity(double newSpecificGravity) {
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

    public void setOccurrence(String[] newOccurrence) {
        this.occurrence = newOccurrence;
    }

    //getters

    public String getCardType() {
        return this.cardType;
    }

    public String getTitle() {
        return this.title;
    }

    public String setSubtitle() {
        return this.subtitle;
    }

    public String setChemistry() {
        return this.chemistry;
    }

    public String setClassification() {
        return this.classification;
    }

    public String setCrystalSystem() {
        return this.crystalSystem;
    }

    public double setHardness() {
        return this.hardness;
    }

    public double setSpecificGravity() {
        return this.specificGravity;
    }

    public String setCleavage() {
        return this.cleavage;
    }

    public String setCrustalAbundance() {
        return this.crustalAbundance;
    }

    public String setEconomicValue() {
        return this.economicValue;
    }

    public String[] setOccurrence() {
        return this.occurrence;
    }
}
