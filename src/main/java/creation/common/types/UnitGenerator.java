package creation.common.types;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.opencsv.CSVReader;
import utilities.CsvHelper;

import static dataresources.csvproperties.Filepaths.UNITS_CSV;


public class UnitGenerator {

	public static String generateUnit() {
		
		String uom = "";
		
		CSVReader reader = CsvHelper.readCsv(UNITS_CSV.getFilepath());
			
		
		String[] nextLine;		
		Set<String> units = new HashSet<>();
		
		try {
			while ((nextLine = reader.readNext()) != null) {
				
				StringBuilder builder = new StringBuilder();
				StringBuilder part1Builder = new StringBuilder();
				StringBuilder part2Builder = new StringBuilder();
				
				char[] part1Chars = nextLine[1].toCharArray();
				char[] part2Chars = nextLine[2].toCharArray();
				
				int index = 0;
				
				for (char character : part1Chars) {
					if (!(character == ' ' 
							&& (index == part1Chars.length - 1
							|| index == 0))) {
						part1Builder.append(character + "");
					}
					index++;
				}
				
				builder.append(part1Builder.toString());				
				index = 0;
				
				for (char character : part2Chars) {
					if (!(character == ' '
							&& (index == part2Chars.length - 1)
							|| (index == 0))) {
						part2Builder.append(character + "");
					}
					index++;
				}
				
				builder.append(" (" + part2Builder.toString() + ")");
				units.add(builder.toString());				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		Random rand = new Random();
		
		int unitsSize = units.size();		
		int unitsRandIndex = rand.nextInt(0, unitsSize);
		
		Object[] unitObjects = units.toArray();				
		
		uom = (String) unitObjects[unitsRandIndex];
		
		return uom;		
	}
	
}
