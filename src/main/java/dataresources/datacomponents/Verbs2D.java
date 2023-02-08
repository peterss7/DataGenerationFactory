package dataresources.datacomponents;

public enum Verbs2D {

    VERBS(new String[][] {
        {"burn", "burn", "burns", "burn", "burn", "burn"},
        {"cry", "cry", "cries", "cry", "cry", "cry"},
        {"breathe", "breathe", "breathes", "breathe", "breathe", "breathe"},
        {"dream", "dream", "dreams", "dream", "dream", "dream"},
        {"pray", "pray", "prays", "pray", "pray", "pray"},
        {"reign", "reign", "reigns", "reign", "reign", "reign"},
        {"scream", "scream", "screams", "scream", "scream", "scream"},
        {"lacerate", "lacerate", "lacerates", "lacerate", "lacerate", "lacerate"},
        {"ravage", "ravage", "ravages", "ravage", "ravage", "ravage"},
        {"decimate", "decimate", "decimates", "decimate", "decimate", "decimate"},
        {"subvert", "subvert", "subverts", "subvert", "subvert", "subvert"},
        {"extort", "extort", "extorts", "extort", "extort", "extort"},
        {"sabotage", "sabotage", "sabotages", "sabotage", "sabotage", "sabotage"},
        {"bludgeon", "bludgeon", "bludgeons", "bludgeon", "bludgeon", "bludgeon"},
        {"medicate", "medicate", "medicates", "medicate", "medicate", "medicate"},
        {"echo", "echo", "echos", "echo", "echo", "echo"},
        {"harass", "harass", "harasses", "harass", "harass", "harass"},
        {"challenge", "challenge", "challenges", "challenge", "challenge", "challenge"},
        {"critique", "critique", "critiques", "critique", "critique", "critique"}
    });

    String[][] verbs;

    Verbs2D(String[][] verbs){
        this.verbs = verbs;
    }

    public String[][] getVerbs(){
        return verbs;
    }





}
