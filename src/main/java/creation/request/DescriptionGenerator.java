package creation.request;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dataresources.datacomponents.Verbs2D;
import utilities.BetterRand;
import utilities.Console;
import utilities.CsvHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.ADVERBS_CSV;
import static dataresources.datacomponents.GrammaticalWords.*;
import static dataresources.datacomponents.Verbs2D.VERBS;

public class DescriptionGenerator {

    public static int personalPronounsSize;
    public static int personalPronounsObjectSize;

    public static int verbsSize;
    public static int indefinitePronounsSize;
    public static int interrogativePronounSize;
    public static int demonstrativePronounSize;
    public static int possessivePronounsSize;
    public static int possessiveAdjectivesSize;
    public static List<String> adverbs;
    public static int adverbsSize;
    public static int subjectIndex;

    public DescriptionGenerator(){
        personalPronounsSize = PERSONAL_PRONOUNS.getWords().length;
        personalPronounsObjectSize = PERSONAL_PRONOUNS_OBJECT.getWords().length;
        verbsSize = VERBS.getVerbs().length;
        indefinitePronounsSize = INDEFINITE_PRONOUNS.getWords().length;
        interrogativePronounSize = INTEROGATIVE_PRONOUNS.getWords().length;
        demonstrativePronounSize = DEMONSTRATIVE_PRONOUNS.getWords().length;
        adverbs = new ArrayList<>();
        setAdverbs();
        possessivePronounsSize = POSSESSIVE_PRONOUNS.getWords().length;
        possessiveAdjectivesSize = POSSESSIVE_ADJECTIVES.getWords().length;
    }

    public void setAdverbs(){

        String[] nextAdverb;

        CSVReader adverbsReader = CsvHelper.readCsv(ADVERBS_CSV.getFilepath());

        try {
            while ((nextAdverb = adverbsReader.readNext()) != null) {
                adverbs.add(nextAdverb[0]);
            }
        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

        adverbsSize = adverbs.size();
    }

    public static String getPersonalPronoun(){

        subjectIndex = BetterRand.randInRange(0,personalPronounsSize - 1);

        if (subjectIndex == 2) {
            return GENDER_PRONOUNS.getWords()[BetterRand.randInRange(0,1)];
        }
        else{
            return PERSONAL_PRONOUNS.getWords()[subjectIndex];
        }
    }

    public String getPossessivePronoun(){
        return "";
    }
    public String getPossessiveAdjective(){
        return "";
    }
    public String getAdjective(){
        return "";
    }
    public static String getInterrogativePronoun(){
        int randIndex = BetterRand.randInRange(0, interrogativePronounSize -1);
        return INTEROGATIVE_PRONOUNS.getWords()[randIndex];
    }
    public static String getIndefinitePronoun(){
        int randIndex = BetterRand.randInRange(0, indefinitePronounsSize - 1);
        return INDEFINITE_PRONOUNS.getWords()[randIndex];
    }
    public static String getAdverb(){
        int randIndex = BetterRand.randInRange(0, adverbsSize - 1);
        return adverbs.get(randIndex);
    }

    public static String getVerb(){
        int randIndex = BetterRand.randInRange(0, verbsSize - 1);
        return VERBS.getVerbs()[randIndex][subjectIndex];
    }
    public static String getVerb(int otherSubjectIndex){
        int randIndex = BetterRand.randInRange(0, verbsSize - 1);
        return VERBS.getVerbs()[randIndex][otherSubjectIndex];
    }
    // returns pronoun and it's plurality
    public static String[] getDemonstrativePronoun(){
        String plurality = "";

        int randIndex = BetterRand.randInRange(0, demonstrativePronounSize - 1);
        String demonNoun = DEMONSTRATIVE_PRONOUNS.getWords()[randIndex];

        if (randIndex % 2 == 1) plurality = "TRUE";
        else plurality = "FALSE";

        return (new String[] {demonNoun,plurality});
    }
    public static String getFormatVendorName(String plurality, String productName){

        StringBuilder builder = new StringBuilder();

        builder.append(productName);

        if (plurality.equals("TRUE")){
            if (productName.substring(productName.length() - 1, productName.length()).equals("s")){
                builder.append("es");
                return builder.toString();
            }
            else {
                builder.append("s");
                return builder.toString();
            }
        }
        else {
            return builder.toString();
        }
    }
    public static String generateDescription(String productName){

        String result = "";
        StringBuilder builder = new StringBuilder();

        //int sentenceStructureDeterminer = BetterRand.randInRange(0, 5);
        int sentenceStructureDeterminer = 0;

        switch(sentenceStructureDeterminer){
            case 0:

                subjectIndex = BetterRand.randInRange(0, PERSONAL_PRONOUNS.getWords().length - 1);
                String personalPronoun = getPersonalPronoun();
                String adverb = getAdverb();
                String verb = getVerb();
                String indefinitePronoun = getIndefinitePronoun();
                String interrogativePronoun = getInterrogativePronoun();
                String adverb2 = getAdverb();
                String verb2 = getVerb(2);
                String[] demonstativePronoun = getDemonstrativePronoun();
                String formattedProductName = getFormatVendorName(demonstativePronoun[1], productName);

                builder.append(personalPronoun + " ");
                builder.append(adverb + " ");
                builder.append(verb + " ");
                builder.append(indefinitePronoun + " ");
                builder.append(interrogativePronoun + " ");
                builder.append(adverb2 + " ");
                builder.append(verb2 + " ");
                builder.append(demonstativePronoun[0] + " ");
                builder.append(formattedProductName + " ");

                result = builder.toString();

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            default:
                break;
        }
        return result;
    }
}
