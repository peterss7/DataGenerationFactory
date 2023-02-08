package factory.users;

import creation.common.contact.EmailGenerator;
import creation.common.contact.PhoneNumberGenerator;
import creation.user.*;
import interfaces.DataGenerator;

import static dataresources.csvproperties.Headers.USER_HEADERS;

public class UserRow implements DataGenerator {

    public String[] orderedHeaders;
    public String[] headers;
    public static int currentIteration;
    String id, username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin;

    public UserRow(int currentIteration)
    {
        this.currentIteration = currentIteration + 1;
        headers = USER_HEADERS.getHeaders();
        orderedHeaders = new String[headers.length];
    }

    @Override
    public String[] getDataRow(){

        String[] result;

        orderHeaders();

        for (String header : orderedHeaders){
            generateData(header);
        }

        result = new String[]{id, username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin};

        return result;
    }

    @Override
    public void generateData(String tableDataType){

        String result = "";

        switch (tableDataType){
            case "Id":
                result = currentIteration + "";
                id = result;
                break;
            case "Username":
                result = UsernameGenerator.generateUsername(firstName, lastName);
                username = result;
                break;
            case "Password":
                result = PasswordGenerator.generatePassword();
                password = result;
                break;
            case "FirstName":
                result = FirstNameGenerator.getFirstName();
                firstName = result;
                break;
            case "LastName":
                result = LastNameGenerator.getLastName();
                lastName = result;
                break;
            case "PhoneNumber":
                result = PhoneNumberGenerator.generatePhoneNumber();
                phoneNumber = result;
                break;
            case "Email":
                result = EmailGenerator.generateEmailByName(firstName, lastName);
                email = result;
                break;
            case "IsReviewer":
                result = IsReviewerGenerator.generateIsReviewer() + "";
                isReviewer = result;
                break;
            case "IsAdmin":
                result = IsAdminGenerator.generateIsAdmin() + "";
                isAdmin = result;
                break;
            default:
                result = "";
                break;
        }
    }

    public void orderHeaders(){

        orderedHeaders[0] = headers[0];
        orderedHeaders[1] = headers[3];
        orderedHeaders[2] = headers[4];
        orderedHeaders[3] = headers[1];
        orderedHeaders[4] = headers[2];
        orderedHeaders[5] = headers[5];
        orderedHeaders[6] = headers[6];
        orderedHeaders[7] = headers[7];
        orderedHeaders[8] = headers[8];



    }

}
