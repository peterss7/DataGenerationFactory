package creation.common.location;


import utilities.BetterRand;

import static dataresources.datacomponents.StateComponent.STATE_FULL_NAME;

public class StateGenerator {

    public static String generateState(){

        int stateIndex = BetterRand.randInRange(1,50);

        // Console.println("random state index: " + stateIndex);

        String stateName = STATE_FULL_NAME.getArray()[stateIndex];

        return stateName;
    }



}
