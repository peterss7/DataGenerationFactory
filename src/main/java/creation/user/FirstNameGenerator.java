package creation.user;

import dataresources.datacomponents.NameComponent;

import java.util.Random;

public class FirstNameGenerator {

    public static String getFirstName() {

        Random rand = new Random();
        int firstNameRandIndex = rand.nextInt(NameComponent.FIRST_NAMES.getArray().length);

        return NameComponent.FIRST_NAMES.getArray()[firstNameRandIndex];
    }

}
