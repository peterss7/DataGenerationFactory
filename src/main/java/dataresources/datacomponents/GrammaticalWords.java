package dataresources.datacomponents;

public enum GrammaticalWords {

    PERSONAL_PRONOUNS(new String[]{"i", "you", "it", "we", "you all", "they"}),
    GENDER_PRONOUNS(new String[] {
            "he", "she"
    }),
    PERSONAL_PRONOUNS_OBJECT(new String[] {
       "me", "you", "it", "us", "you", "them"
    }),
    GENDER_PRONOUNS_OBJECT(new String[] {
       "him", "her"
    }),
    POSSESSIVE_PRONOUNS(new String[] {
       "mine", "yours", "its", "our", "your", "their"
    }),
    POSSESSIVE_ADJECTIVES(new String[] {
       "my", "your", "its", "ours", "yours", "theirs"
    }),
    ADJECTIVES(new String[]{
            "abrupt", "acidic", "adorable", "adventurous", "aggressive", "agitated", "alert", "aloof", "amiable",
            "amused", "attractive", "annoyed", "antsy", "anxious", "appetizing", "beautiful", "blushing", "bored", "brave", "bold", "clean", "broad",
            "comfortable", "crabby", "creepy", "bright", "crooked", "defiant", "defeated", "deep", "cruel", "deceitful",
            "defiant", "delicious", "dilapidated", "delightful", "depraved", "despicable", "determined", "encouraging",
            "energetic", "enthusiastic", "envious", "evil", "demonic", "enormous", "exasperated", "depressed", "excited",
            "exhilarated", "flat", "floppy", "fluttering", "foolish", "frantic", "gleaming", "golden", "funny", "fuzzy",
            "frothy", "fresh", "friendly", "frightened", "frustrating", "glorious", "gorgeous", "graceful", "horrific", "greasy",
            "homely", "irate", "jealous", "grieving", "gritty", "high", "hollow", "high", "huge", "hungry", "hurt", "icy", "ideal",
            "immense", "intrigued", "irritable", "itchy", "jittery", "jolly", "joyous", "ludicrous", "macho", "magnificent",
            "mammoth", "maniacal", "massive", "melted", "nonsensical", "nutritious", "nutty", "obedient", "obnoxious", "oblivious",
            "outrageous", "panicky", "perfect", "pleasant", "plain", "ripe", "shaggy", "petty", "petite", "perplexed", "poised",
            "substantial", "superior", "superfluous", "succulent", "wicked", "whooping", "zippy", "zealous", "zany", "yummy", "witty",
            "wobbly", "wonderful", "worried", "thick", "testy", "superficial", "shaky", "successful"
    }),
    // Even,        Odd,        Even,           Odd
    // %2 = 0      %2= 1,       %2 = 0          %2 = 1
    NOUNS(new String[]{
            "people", "history", "way", "art", "world", "information", "map", "two",
            "family", "government", "health", "system", "computer", "meat", "year", "thanks", "music",
            "person", "reading", "method", "data", "food", "understanding", "theory", "law", "bird",
            "literature", "problem", "software", "control", "knowledge", "power", "ability", "economics",
            "love", "internet", "television", "science", "library", "nature", "fact", "product",
            "idea", "temperature", "investment", "area", "society"
    }),
    TO_BE_PRESENT(new String[] {
            "am", "are", "is", "are", "are", "are"
    }),
    TO_HAVE_PRESENT(new String[] {
            "have", "have", "has", "have", "have", "have"
    }),
    TO_BE_PAST(new String[] {
            "was", "were", "was", "were", "were", "were"
    }),
    TO_HAVE_PAST(new String[] {
            "had", "had", "had", "had", "had", "had"
    }),
    TO_BE_FUTURE(new String[] {
            "will be", "will be", "will be", "will be", "will be", "will be"
    }),
    TO_HAVE_FUTURE(new String[] {
            "will have", "will have", "will have", "will have", "will have", "will have"
    }),
    COORDINATING_CONJUNCTIONS(new String[]{
            "for", "and", "nor", "but", "or", "yet", "so"
    }),
    SUBORDINATE_CONJUNCTIONS(new String[]{
            "after", "as long as", "as soon as", "as though", "before",
            "even if", "if", "just as", "now", "now that", "once", "provided that", "since",
            "supposing", "though", "until", "whenever", "whereas", "wherever", "which", "who"
    }),
    INDEFINITE_PRONOUNS(new String[]{
            "anybody", "anyone", "anything",
            "everybody", "everyone", "everything", "nothing",
            "somebody", "someone", "something"
    }),
    DEMONSTRATIVE_PRONOUNS(new String[]{
            "this", "these", "that", "those"
    }),
    INTEROGATIVE_PRONOUNS(new String[]{
        "who", "which", "that"
    }),
    RELATIVE_PRONOUNS(new String[] {
            "whoever", "whichever", "whatever"
    }),
    INTENSIVE_PRONOUNS(new String[] {
            "myself", "yourself", "himself", "herself", "itself", "ourselves", "yourselves", "themselves"
    });

    public String[] words;

    GrammaticalWords(String[] word){
        this.words = word;
    }

    public String[] getWords(){
        return words;
    }

}
