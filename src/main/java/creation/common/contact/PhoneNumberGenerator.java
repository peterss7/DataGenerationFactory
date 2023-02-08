package creation.common.contact;



import java.util.Random;

import static dataresources.datacomponents.PhoneNumberComponent.AREA_CODES;
import static dataresources.datacomponents.StateComponent.STATE_FULL_NAME;


public class PhoneNumberGenerator {

    public static String generatePhoneNumber() {

        String phoneNumber = getAreaCode() + "-" + addRandomsByLength(3) +
                "-" + addRandomsByLength(4);
        return phoneNumber;
    }

    public static String generatePhoneNumberByStateName(String stateName){

        String[] states = STATE_FULL_NAME.getArray();
        int id = 0;

        for (int i = 0; i < states.length; i++){
            if (stateName.equals(states[i])){
                id = i;
            }
        }

        return  getAreaCodeById(id) + "-" + addRandomsByLength(3) + "-" + addRandomsByLength(4);
    }

    public static String getAreaCodeById(int id) {

        return AREA_CODES.getArray()[id];

    }

    public static String addRandomsByLength(int length){

        Random rand = new Random();
        String rands = "";

        for (int i = 0; i < length; i++){
            rands += rand.nextInt(10);
        }

        return rands;

    }

    public static String getAreaCode(){

        Random rand = new Random();

        String areaCode = AREA_CODES.getArray()[rand.nextInt(50)];

        return areaCode;
    }
}
