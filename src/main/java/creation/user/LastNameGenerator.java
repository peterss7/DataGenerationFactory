package creation.user;

import dataresources.datacomponents.NameComponent;

import java.util.Random;

public class LastNameGenerator {

    public static String getLastName() {
        Random rand = new Random();

        int lastNameRandIndex = rand.nextInt(NameComponent.LAST_NAMES.getArray().length);

        return NameComponent.LAST_NAMES.getArray()[lastNameRandIndex];
    }
}
