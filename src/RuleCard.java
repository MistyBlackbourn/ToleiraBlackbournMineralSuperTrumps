public class RuleCard extends Card {
    private String subtitle;


    RuleCard(String title, String cardType, String subtitle) {
        super(cardType, title);
        this.subtitle = subtitle;
    }

    //setters

    public void setSubtitle(String newSubtitle) {
        this.subtitle = newSubtitle;
    }


    //getters

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getChemistry() {
        return null;
    }

    public String getClassification() {
        return null;
    }

    public String getCrystalSystem() {
        return null;
    }

    public String getHardness() {
        return null;
    }

    public String getSpecificGravity() {
        return null;
    }

    public String getCleavage() {
        return null;
    }

    public String getCrustalAbundance() {
        return null;
    }

    public String getEconomicValue() {
        return null;
    }

    public String getOccurrence() {
        return null;
    }

}
