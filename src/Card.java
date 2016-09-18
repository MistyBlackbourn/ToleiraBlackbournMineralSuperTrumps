public abstract class Card {
    private String cardType;
    private String title;

    Card(String cardType, String title) {
        this.cardType = cardType;
        this.title = title;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public abstract String getOccurrence();
}
