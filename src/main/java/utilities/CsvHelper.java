package utilities;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class CsvHelper {

    public static void buildCsv(List<String[]> data, String[] headerRecord, int[] nullableColumns, String filepath) {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(filepath));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.DEFAULT_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {

            csvWriter.writeNext(headerRecord);

            Random rand = new Random();

            for (int i = 0; i < data.size(); i++) {

                String csvLine[] = new String[data.get(0).length];
                for (int j = 0; j < csvLine.length; j++)
                {
                    csvLine[j] = data.get(i)[j];

                    boolean isNullableColumn = false;
                    for (int k = 0; k < nullableColumns.length; k++) {
                        if (j == nullableColumns[k]) {
                            isNullableColumn = true;
                        }
                    }

                    if (isNullableColumn) {
                        if (rand.nextInt(100) > 75) csvLine[j] = null;
                    }
                }
                csvWriter.writeNext(csvLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CSVReader readCsv(String filepath) {

        CSVReader reader = null;

        // Console.println(filepath);

        try {
            reader = new CSVReader(new FileReader(filepath));
            // Console.println("Reader just read the filepath");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }

    public static String getCellByColumnValue(String value, int targetColumn, String filepath) {

        CSVReader reader = readCsv(filepath);
        String targetInfo = "";

        String[] nextLine;
        try {
            while((nextLine = reader.readNext()) != null) {
                if (nextLine[targetColumn].equals(value)) {
                    targetInfo = nextLine[targetColumn];
                }
            }
        } catch (CsvValidationException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return targetInfo;

    }


}
