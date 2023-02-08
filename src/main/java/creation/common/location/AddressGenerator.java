package creation.common.location;


import org.fluttercode.datafactory.impl.DataFactory;

public class AddressGenerator {

    public static String generateAddress(){


        DataFactory df = new DataFactory();

        return df.getAddress();

    }
}
