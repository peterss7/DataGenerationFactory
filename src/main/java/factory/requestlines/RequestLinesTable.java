package factory.requestlines;

import factory.requests.RequestRow;
import interfaces.TableFactory;
import utilities.Console;
import utilities.CsvHelper;

import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.REQUEST_LINES;
import static dataresources.csvproperties.Headers.REQUEST_LINE_HEADERS;
import static dataresources.csvproperties.Nullables.REQUEST_LINE_NULLABLES;

public class RequestLinesTable extends TableFactory {

    public String[] headers = REQUEST_LINE_HEADERS.getHeaders();
    public int[] nullables = REQUEST_LINE_NULLABLES.getNullables();
    public String filepath = REQUEST_LINES.getFilepath();
    int iterations;

    List<String[]> tableData = new ArrayList<>();

    public RequestLinesTable(int iterations){
        this.iterations = iterations;
    }

    @Override
    public void createTableData(){
        for (int i = 0; i < iterations; i++){
            RequestLineRow currentRequestLine = new RequestLineRow(i, headers);
            tableData.add(currentRequestLine.getDataRow());
        }

        checkForDuplicates();
    }

    @Override
    public void createTableCsv(){
        CsvHelper.buildCsv(tableData, headers, nullables, filepath);
    }


    public void checkForDuplicates(){
        for (int i = 0; i < tableData.size(); i++){
            String requestId = tableData.get(i)[1];
            for (int j = i + 1; j < tableData.size(); j++){
                if (requestId.equals(tableData.get(j)[1])) {
                    if (tableData.get(i)[2].equals(tableData.get(j)[2])) {
                        // Console.println("duplicate requestLine removed.");
                        tableData.remove(j);
                    }
                }
            }
        }
    }

}
