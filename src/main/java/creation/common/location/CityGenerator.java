package creation.common.location;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utilities.BetterRand;
import utilities.CsvHelper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static dataresources.csvproperties.Filepaths.CITIES_AND_STATES_CSV;

public class CityGenerator {

    public static String generateCity(String stateName){

        CSVReader reader = CsvHelper.readCsv(CITIES_AND_STATES_CSV.getFilepath());
        String[] nextLine;
        List<String> cities;



        try {

            cities = new ArrayList<>();

            reader.readNext();
            nextLine = (reader.readNext() != null) ? reader.readNext() :  null;
            //Console.println(nextLine[0] + " is 0");
            while((nextLine = reader.readNext()) != null){
                //Console.println(nextLine[2] + " is 0 in the while and gotten state: " + stateName);
                //Console.println(nextLine[1] + " is 1 in the whileand gotten state: " + stateName);
                if (nextLine[2].equals(stateName)){
                    cities.add(nextLine[1]);
                    //Console.println("city added");
                }
            }

            int randomCityIndex;

            // Console.println("Cities size: " + cities.size());

            if (!(cities.size() < 0 || cities.isEmpty()) ) {
                randomCityIndex = BetterRand.randInRange(1, cities.size() - 1);
                // Console.println("Cities size: " + cities.size() + ", index: " + randomCityIndex);
                return cities.get(randomCityIndex);
            }
            else {
                // Console.println("Cities size: " + cities.size() + ", no index possible index");
                return "ERROR";
            }

        } catch (CsvValidationException | IOException e){
            e.printStackTrace();
            return "oopsies";
        }





    }

}
