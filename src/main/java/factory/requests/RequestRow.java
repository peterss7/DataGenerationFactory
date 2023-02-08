package factory.requests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import creation.request.*;

import interfaces.DataGenerator;
import utilities.Console;
import utilities.CsvHelper;

import java.io.IOException;

import static dataresources.csvproperties.Filepaths.PRODUCTS;
import static dataresources.csvproperties.Filepaths.REQUEST_LINES;


public class RequestRow implements DataGenerator {

    private String[] orderedHeaders;
    private String[] headers;
    private static int currentIteration;
    private String id, description, justification, rejectionReason,
            deliveryMode, submittedDate, dateNeeded, status, total, userId;
    private String productId, productName, requstLineId;
    private boolean isValid;

    public RequestRow(int currentIteration, String[] headers)
    {
        this.currentIteration = currentIteration + 1;
        this.headers = headers;
        orderedHeaders = new String[this.headers.length];
        getRowValidity();
    }

    @Override
    public String[] getDataRow(){

        String[] result;

        if (isValid) {

            orderHeaders();

            for (int i = 0; i < headers.length; i++) {
                generateData(orderedHeaders[i]);
            }

            result = new String[]{
                    id, description, justification, rejectionReason,
                    deliveryMode, submittedDate, dateNeeded, status, total, userId
            };

            return result;
        }
        else{
            return null;
        }
    }

    @Override
    public void generateData(String tableDataType){

        getProductName();

        switch (tableDataType){
            // 0
            case "Id":
                id = currentIteration + "";
                break;
            // 1
            case "Description":
                DescriptionGenerator dg = new DescriptionGenerator();
                description = DescriptionGenerator.generateDescription(productName);
                break;
            // 2
            case "Justification":
                justification = JustificationGenerator.generateJustification();
                break;
            // 3
            case "RejectionReason":
                rejectionReason = RejectionReasonGenerator.generateRejectionReason();
                break;
            // 4
            case "DeliveryMode":
                deliveryMode = DeliveryModeGenerator.generateDeliveryMode();
                break;
            // 5
            case "SubmittedDate":
                submittedDate = SubmittedDateGenerator.generateSubmittedDate();
                break;
            // 6
            case "DateNeeded":
                dateNeeded = DateNeededGenerator.generateDateNeeded();
                break;
            // 7
            case "Status":
                status = StatusGenerator.generateStatus();
                break;
            // 8
            case "Total":
                total = TotalGenerator.generateTotal();
                break;
            // 9
            case "UserId":
                userId = UserIdGetter.getUserId();
                break;
            default:
                Console.println(tableDataType + ": ????");
                break;
        }
    }



    private void orderHeaders(){
        // id
        orderedHeaders[0] = headers[0];
        // description
        orderedHeaders[1] = headers[1];
        // justification
        orderedHeaders[2] = headers[2];
        // rejectionReason
        orderedHeaders[3] = headers[3];
        // deliveryMode
        orderedHeaders[4] = headers[4];
        // submittedDate
        orderedHeaders[5] = headers[5];
        // dateNeeded
        orderedHeaders[6] = headers[6];
        // Status
        orderedHeaders[7] = headers[7];
        // total
        orderedHeaders[8] = headers[8];
        // quantity
        orderedHeaders[9] = headers[9];
    }

    private boolean getRowValidity(){

        CSVReader requestLinesReader = CsvHelper.readCsv(REQUEST_LINES.getFilepath());

        String[] nextRequestLine;

        try{
            while ((nextRequestLine = requestLinesReader.readNext()) != null){
                if ((currentIteration + "").equals(nextRequestLine[1])){
                    requstLineId = currentIteration + "";
                    productId = nextRequestLine[2];
                   // Console.println("requestId: " + currentIteration +
                   //         ", requestlineId: " + requstLineId +
                   //         ", productId: " + productId);
                    isValid = true;
                    break;
                }
            }
        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

        return isValid;
    }

    private void getProductName(){

        CSVReader reader = CsvHelper.readCsv(PRODUCTS.getFilepath());

        String[] nextProduct;

        // Console.println("productid in get product name: " + productId);

        try{
            while ((nextProduct = reader.readNext()) != null){
                if (productId.equals(nextProduct[0])){
                    productName = nextProduct[2];
                }
            }
        } catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }

    public boolean getValidity(){
        return isValid;
    }

}
