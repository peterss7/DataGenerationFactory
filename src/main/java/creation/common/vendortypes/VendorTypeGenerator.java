package creation.common.vendortypes;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import dataresources.csvproperties.Filepaths;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilities.CsvHelper;

public class VendorTypeGenerator {

    public static String[] getVendorTypes(){

        CSVReader csvReader = CsvHelper.readCsv(Filepaths.VENDOR_TYPES_CSV.getFilepath());
        List<String[]> vendorTypes = new ArrayList<>();

        try {
            vendorTypes = csvReader.readAll();
        } catch (IOException | CsvException e1) {
            e1.printStackTrace();
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        vendorTypes.remove(0);

        String[] result = new String[vendorTypes.size()];

        int count = 0;
        for (String[] row : vendorTypes) {
            result[count] = row[0];
            count++;
        }

        return result;
    }

}
