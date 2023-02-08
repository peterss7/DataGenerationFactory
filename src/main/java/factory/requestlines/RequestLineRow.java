package factory.requestlines;

import creation.requestline.ProductIdGenerator;
import creation.requestline.QuantityGenerator;
import creation.requestline.RequestIdGenerator;
import interfaces.DataGenerator;
import utilities.Console;

public class RequestLineRow implements DataGenerator {

    public String[] orderedHeaders;
    public String[] headers;
    public static int currentIteration;
    String id, requestId, productId, quantity;

    public RequestLineRow(int currentIteration, String[] headers)
    {
        this.currentIteration = currentIteration + 1;
        this.headers = headers;
        orderedHeaders = new String[this.headers.length];
    }

    @Override
    public String[] getDataRow(){

        String[] result;

        orderHeaders();

        for (int i = 0; i < headers.length; i++){
            generateData(orderedHeaders[i]);
        }

        result = new String[] {
                id, requestId, productId, quantity
        };

        return result;

    }

    @Override
    public void generateData(String tableDataType){

        switch (tableDataType){
            case "Id":
                id = currentIteration + "";
                break;
            case "RequestId":
                requestId = RequestIdGenerator.generateRequestId();
                break;
            case "ProductId":
                productId = ProductIdGenerator.getProductId();
                break;
            case "Quantity":
                quantity = QuantityGenerator.generateQuantity();
                break;
            default:
                Console.println(tableDataType + ": ????");
                break;
        }
    }



    public void orderHeaders(){
        // Id
        orderedHeaders[0] = headers[0];
        // requestId
        orderedHeaders[1] = headers[1];
        // productId
        orderedHeaders[2] = headers[2];
        // quantity
        orderedHeaders[3] = headers[3];


    }


}
