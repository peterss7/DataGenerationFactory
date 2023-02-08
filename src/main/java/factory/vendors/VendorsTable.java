package factory.vendors;

import interfaces.TableFactory;
import utilities.Console;
import utilities.CsvHelper;

import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.VENDORS;
import static dataresources.csvproperties.Headers.VENDOR_HEADERS;
import static dataresources.csvproperties.Nullables.VENDOR_NULLABLES;

public class VendorsTable extends TableFactory {

    public String[] headers = VENDOR_HEADERS.getHeaders();
    public int[] nullables = VENDOR_NULLABLES.getNullables();
    public String filepath = VENDORS.getFilepath();
    int iterations;

    List<String[]> tableData = new ArrayList<>();

    public VendorsTable(int iterations){
        this.iterations = iterations;
    }

    @Override
    public void createTableData(){

        for (int i = 0; i < iterations; i++){
            VendorRow currentVendor = new VendorRow(i);
            String[] newRow = currentVendor.getDataRow();
            if (newRow != null) {
                tableData.add(newRow);
            }
        }
    }

    @Override
    public void createTableCsv(){
        CsvHelper.buildCsv(tableData, headers, nullables, filepath);
    }

}
