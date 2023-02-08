package creation.requestline;

import utilities.BetterRand;

public class QuantityGenerator {

    public static String generateQuantity (){
        String result = "";

        result = BetterRand.randInRange(1, 25) + "";

        return result;
    }

}
