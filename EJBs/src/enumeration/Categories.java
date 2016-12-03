package enumeration;

public enum Categories {

    MOTEUR("bateau à moteur"),
    VOILE("bateau à voile"),
    PENICHE("péniche"),
    GONFLABLE("bateau gonflable"),
    JET("jet-ski"),
    ALU("bateau aluminium");

    private String categoryText;

    Categories(String categoryText) {
        this.categoryText = categoryText;
    }

    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

}
