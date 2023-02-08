package creation.requestline;

import creation.common.common_strings.CodeGenerator;
import utilities.BetterRand;

import static dataresources.csvproperties.TableSizes.REQUESTS_SIZE;

public class RequestIdGenerator {

    public static String generateRequestId (){

        String result = "";

        result = BetterRand.randInRange(1, REQUESTS_SIZE.getSize()) + "";

        return result;

    }

}
