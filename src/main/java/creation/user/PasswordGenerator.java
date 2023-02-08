package creation.user;

import utilities.BetterRand;

import java.util.Random;

import static dataresources.datacomponents.PasswordComponent.SPECIAL_CHARACTERS;

public class PasswordGenerator {

    public static String generatePassword(){

        String result = "";

        Random rand = new Random();

        int charactersRandLength = BetterRand.randInRange(6,11);

        for (int i = 0; i < charactersRandLength; i++){
            result += (char)('a' + BetterRand.randInRange(0,26)) + "";
        }

        int numberOfCaps = BetterRand.randInRange(2, 5);
        for (int i = 0; i < numberOfCaps; i++){

            int uppercaseRandIndex = BetterRand.randInRange(0, result.length() - 1);

            String resultPart1 = result.substring(0,uppercaseRandIndex);
            String resultPart2 = result.substring(uppercaseRandIndex + 1);
            String capitalizedChar = result.substring(uppercaseRandIndex, uppercaseRandIndex + 1).toUpperCase();

            result = resultPart1 + capitalizedChar + resultPart2;

        }

        int numberOfSpecialChars = BetterRand.randInRange(1,5);
        for (int i = 0; i < numberOfSpecialChars; i++){
            int specialCharRandIndex = BetterRand.randInRange(0, result.length() - 1);

            String resultPart1 = result.substring(0, specialCharRandIndex);
            String resultPart2 = result.substring(specialCharRandIndex + 1);
            String specialChar = SPECIAL_CHARACTERS.getArray()
                    [BetterRand.randInRange(0, SPECIAL_CHARACTERS.getArray().length - 1)] + "";

            result = resultPart1 + specialChar + resultPart2;
        }

        int endNumbers = BetterRand.randInRange(1000, 9999);

        result += endNumbers + "";

        /*

        Random rand = new Random();
        String password = "";
        String temp = "";

        int randomLength = BetterRand.randInRange(5,10);

        for (int i = 0; i < randomLength; i++){
            temp += (char)('a' + 26) + "";
        }

        int tempUppercaseIndex = rand.nextInt(temp.length());
        int specialCharIndex = rand.nextInt(temp.length());

        char specialChar = SPECIAL_CHARACTERS.getArray()
                [rand.nextInt(SPECIAL_CHARACTERS.getArray().length)];
        char[] passwordChars = temp.toCharArray();
        String uppercaseChar = Character.toString(passwordChars[tempUppercaseIndex]).toUpperCase();

        for (int j = 0; j < passwordChars.length; j++)
        {
            if (j == tempUppercaseIndex) password += uppercaseChar;
            else password += Character.toString(passwordChars[j]);

            if (j == specialCharIndex) password += Character.toString(specialChar);
        }

        password += rand.nextInt(1000);

        return password;

         */

        return result;

    }
}
