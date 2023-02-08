package dataresources.datacomponents;

public enum DescriptionComponent {

    WORD_SEQUENCES(new String[][]{
            {"The ", "is a ", "is an ", "and is suitible for ", "of our ",
                "people."},
            {"It is a ", "it is an ", "that is used for ", ". It was ",
                "for ", "people."}
    });

    private final String[][] words;

    DescriptionComponent(String[][] words) {
        this.words = words;
    }

    public String[][] getSequence() {
        return words;
    }
}
