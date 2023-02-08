package factory.requests;

import factory.products.ProductRow;
import interfaces.TableFactory;
import utilities.Console;
import utilities.CsvHelper;

import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.REQUESTS;
import static dataresources.csvproperties.Headers.REQUEST_HEADERS;
import static dataresources.csvproperties.Nullables.REQUEST_NULLABLES;


public class RequestsTable extends TableFactory {

    public String[] headers = REQUEST_HEADERS.getHeaders();
    public int[] nullables = REQUEST_NULLABLES.getNullables();
    public String filepath = REQUESTS.getFilepath();
    int iterations;

    List<String[]> tableData = new ArrayList<>();

    public RequestsTable(int iterations){
        this.iterations = iterations;
    }

    @Override
    public void createTableData(){
        for (int i = 0; i < iterations; i++){
            RequestRow currentRequest = new RequestRow(i, headers);
            if (currentRequest.getValidity()) {
                tableData.add(currentRequest.getDataRow());
            }
        }


    }

    @Override
    public void createTableCsv(){
        CsvHelper.buildCsv(tableData, headers, nullables, filepath);
    }

}
