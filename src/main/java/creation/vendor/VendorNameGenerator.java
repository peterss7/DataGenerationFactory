package creation.vendor;

import java.util.Random;

import static creation.common.vendortypes.VendorTypeGenerator.getVendorTypes;
import static dataresources.datacomponents.NameComponent.LAST_NAMES;
import static dataresources.datacomponents.VendorComponent.NOUNS;
import static dataresources.datacomponents.VendorComponent.VERBS;

public class VendorNameGenerator {

    public static String generateName() {

        String[] vendorTypes = getVendorTypes();
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();

        int vendorTypesSize = vendorTypes.length;
        int vendorNounsSize = NOUNS.getWords().length;
        int vendorVerbsSize = VERBS.getWords().length;

        int vendorNounsRandIndex = rand.nextInt(vendorNounsSize);
        int vendorVerbsRandIndex = rand.nextInt(vendorVerbsSize);
        int vendorTypeRandIndex = rand.nextInt(vendorTypesSize);

        String word1 = "";
        String word2 = "";
        String vendorType = vendorTypes[vendorTypeRandIndex];
        String owner = LAST_NAMES.getArray()[rand.nextInt(LAST_NAMES.getArray().length)];

        builder.append(owner + "'s ");
        word1 = VERBS.getWords()[vendorVerbsRandIndex];
        word1 = word1.substring(0, 1).toUpperCase() + word1.substring(1);
        builder.append(word1 + " ");
        word2 = NOUNS.getWords()[vendorNounsRandIndex];
        word2 = word2.substring(0, 1).toUpperCase() + word2.substring(1);
        builder.append(word2 + " ");
        builder.append(vendorType);

        return builder.toString();
    }
}

