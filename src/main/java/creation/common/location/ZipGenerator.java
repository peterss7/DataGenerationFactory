package creation.common.location;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utilities.BetterRand;
import utilities.CsvHelper;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


import static dataresources.csvproperties.Filepaths.STATE_DATA_CSV;
import static dataresources.csvproperties.Filepaths.ZIP_CODE_MASTER;

public class ZipGenerator {

    public static String generateZip(String stateName) {

        List<String> zipData = new ArrayList<>();

        CSVReader reader = CsvHelper.readCsv(STATE_DATA_CSV.getFilepath());

        String[] nextLine;
        String stateAbv = "";

        // Console.println("StateName: " + stateName);

        try {
            while ((nextLine = reader.readNext()) != null){

                // Console.println("looping state abs: " + nextLine) ;

                stateAbv = (stateName.equals(nextLine[0])) ? nextLine[1] : stateAbv;

            }

        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }


        CSVReader reader2 = CsvHelper.readCsv(ZIP_CODE_MASTER.getFilepath());

        String[] nextLine2;

        try{

            reader2.readNext();

            nextLine2 = ((nextLine2 = reader2.readNext()) != null) ? nextLine2 : new  String[]{"", ""};

            while((nextLine2 = reader2.readNext()) != null){
                // Console.println("zip code: " + nextLine2[0] + ", zip's stateAbv: " + nextLine2[1] + ", found stateAbv: " + stateAbv);
                if (nextLine2[1].equals(stateAbv)){
                    zipData.add(nextLine2[0]);
                  //  Console.println("Zip added: " + nextLine2[0]);
                }
                else{
                    // Console.println(("Zip not added."));
                }
            }
        } catch(CsvValidationException | IOException e){
            e.printStackTrace();
        }

        if (!(zipData.isEmpty())) {

            int zipRandIndex = BetterRand.randInRange(1, zipData.size() - 1);
            zipData.get(zipRandIndex);
            // Console.println("zipData Size: " + zipData.size());

            return zipData.get(zipRandIndex);
        }
        else {
            return "not a zip";
        }


    }

}
