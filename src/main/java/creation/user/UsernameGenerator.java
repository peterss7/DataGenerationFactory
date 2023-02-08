package creation.user;

import utilities.BetterRand;

import java.util.Random;

public class UsernameGenerator {

    public static String generateUsername(String firstName, String lastName){

        int numNums = BetterRand.randInRange(1,3);
        int numNum;
        StringBuilder builder = new StringBuilder();

        switch (numNums){
            case 0:
                numNum = BetterRand.randInRange(1,9);
                builder.append(numNum);
                break;
            case 1:
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                break;
            case 2:
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                break;
            case 3:
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                builder.append(BetterRand.randInRange(1,9));
                break;
            default:
                numNum = 0;
                builder.append(numNum);
                break;
        }

        String username = firstName.substring(0,1) + lastName + builder.toString();

        return username;
    }

}
