package creation.requestline;


import utilities.BetterRand;

import static dataresources.csvproperties.TableSizes.PRODUCTS_SIZE;

public class ProductIdGenerator {

    public static String getProductId (){

        String result = "";

        result = BetterRand.randInRange(1, PRODUCTS_SIZE.getSize()) + "";

        return result;

    }

}
