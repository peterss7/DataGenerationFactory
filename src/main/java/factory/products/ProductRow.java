package factory.products;

import creation.common.types.UnitGenerator;
import creation.product.*;
import interfaces.DataGenerator;
import utilities.Console;
import utilities.CsvHelper;

import static dataresources.csvproperties.Filepaths.VENDORS;
import static dataresources.csvproperties.Headers.PRODUCT_HEADERS;


public class ProductRow implements DataGenerator {

    public String[] orderedHeaders;
    public String[] headers;
    public static int currentIteration;
    String id, partNumber, name, price, unit, photopath, vendorId;

    public ProductRow(int currentIteration)
    {
        this.currentIteration = currentIteration + 1;
        headers = PRODUCT_HEADERS.getHeaders();
        orderedHeaders = new String[headers.length];
    }

    @Override
    public String[] getDataRow(){

        String[] result;

        orderHeaders();

        for (int i = 0; i < headers.length; i++){
            generateData(orderedHeaders[i]);
        }

        result = new String[] {
                id, partNumber, name, price, unit, photopath, vendorId
        };

        return result;

    }

    @Override
    public void generateData(String tableDataType){

        String result = "";

        switch (tableDataType){
            case "Id":
                id = currentIteration + "";
                break;
            case "PartNumber":
                partNumber = PartNumberGenerator.generatePartNumber(name);
                break;
            case "Name":
                name = ProductNameGenerator.generateName();
                break;
            case "Price":
                price = String.format("$%,.2f", PriceGenerator.generatePrice());
                break;
            case "Unit":
                unit = UnitGenerator.generateUnit();
                break;
            case "Photopath":
                photopath = PhotoPathGenerator.generatePhotoPath(CsvHelper.getCellByColumnValue(vendorId, 1, VENDORS.getFilepath()), partNumber, name);
                break;
            case "VendorId":
                vendorId = VendorIdGenerator.generateVendorId();
                break;
            default:
                Console.println(tableDataType + ": ????");
                break;
        }
    }



    public void orderHeaders(){
        //ID
        orderedHeaders[0] = headers[0];
        // name
        orderedHeaders[1] = headers[2];
        //part number
        orderedHeaders[2] = headers[1];
        // code
        orderedHeaders[3] = headers[6];
        //price
        orderedHeaders[4] = headers[3];
        //unit
        orderedHeaders[5] = headers[4];
        //photopath
        orderedHeaders[6] = headers[5];
    }

}
