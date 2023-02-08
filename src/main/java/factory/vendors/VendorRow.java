package factory.vendors;

import creation.common.contact.EmailGenerator;
import creation.common.contact.PhoneNumberGenerator;
import creation.common.location.AddressGenerator;
import creation.common.location.CityGenerator;
import creation.common.location.StateGenerator;
import creation.common.location.ZipGenerator;
import creation.vendor.*;
import interfaces.DataGenerator;

import static dataresources.csvproperties.Headers.VENDOR_HEADERS;

public class VendorRow implements DataGenerator {

    public String[] orderedHeaders;
    public String[] headers;
    public static int currentIteration;
    String id, code, name, address, city, fullStateName, zip, phone, email;
    public int temp;
    public boolean invalid;

    public VendorRow(int currentIteration)
    {
        invalid = false;
        temp = 0;
        this.currentIteration = currentIteration + 1;
        headers = VENDOR_HEADERS.getHeaders();
        orderedHeaders = new String[headers.length];
    }

    @Override
    public String[] getDataRow(){

        String[] result;

        orderHeaders();

        for (int i = 0; i < headers.length; i++) {
            if (!invalid) {
                generateData(orderedHeaders[i]);
            }
            else
            {
                return null;
            }
        }

        result = new String[]{
                id, code, name, address, city, fullStateName, zip, phone, email
        };

        return result;
    }

    @Override
    public void generateData(String tableDataType){

        switch (tableDataType){
            case "Id":
                id = currentIteration + "";
                break;
            case "Code":
                code =  VendorCodeGenerator.generateCode();
                break;
            case "Name":
                name = VendorNameGenerator.generateName();
                break;
            case "Address":
                address = AddressGenerator.generateAddress();
                break;
            case "City":
                city = CityGenerator.generateCity(fullStateName);
                if (city == "ERROR"){
                    invalid = true;
                }
                break;
            case "State":
                fullStateName = StateGenerator.generateState();
                break;
            case "Zip":
                zip = ZipGenerator.generateZip(fullStateName);
                break;
            case "Phone":
                phone = PhoneNumberGenerator.generatePhoneNumber();
                break;
            case "Email":
                email = EmailGenerator.generateEmailByBusiness(name);
                break;
            default:
                id = "????";
                break;
        }



    }

    public void orderHeaders(){

        orderedHeaders[0] = headers[0];
        orderedHeaders[1] = headers[1];
        orderedHeaders[2] = headers[2];
        orderedHeaders[3] = headers[3];
        orderedHeaders[4] = headers[5];
        orderedHeaders[5] = headers[4];
        orderedHeaders[6] = headers[6];
        orderedHeaders[7] = headers[7];
        orderedHeaders[8] = headers[8];

    }

}
