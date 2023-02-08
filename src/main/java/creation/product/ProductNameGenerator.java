package creation.product;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dataresources.csvproperties.Filepaths;
import utilities.CsvHelper;


public class ProductNameGenerator {
	

	
	public static String generateName() {
	
		CSVReader reader = CsvHelper.readCsv(Filepaths.ASTRONOMY_TERMS_CSV.getFilepath());
		
		String[] nextLine;		
		Set<String> foundAstroObjects = new HashSet<>();
		
		try {
			//reader.readNext();
			
			while ((nextLine = reader.readNext()) != null) {
				
				for(int i = nextLine.length - 1; i >= 0; i--) {
					if (!nextLine[i].contains(",") && nextLine[i].length() > 0) {
						if (!foundAstroObjects.contains(nextLine[i])) {
							String[] temp = nextLine[i].split(" ");
							String temp2 = "";
							if (temp != null) {
								for (String element : temp) {
									//Console.println(temp);
									if (element.length() > 4) {
										if (!(element.substring(element.length() - 3, element.length() - 1).equals("fs"))
											&& !(element.substring(element.length() - 1).equals("s"))
											&& !(element.substring(element.length() - 3).equals("cal"))) {
											temp2 += element.substring(0, 1).toUpperCase() + element.substring(1) + " ";	
										}
									}
									
									
								}
							}
							
							//foundAstroObjects.add(nextLine[i]);
							if (temp2.length() > 4) {
								foundAstroObjects.add(temp2.substring(0, temp2.length() - 1));
							}
						}
					}
				}
			}
		} catch (CsvValidationException | IOException e) {			
			e.printStackTrace();
		}
		
		try {
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		
		CSVReader wordReader = CsvHelper.readCsv(Filepaths.TEN_THOUSAND_WORDS_CSV.getFilepath());
		
		Set<String> foundWords2 = new HashSet<>();
		Set<String> foundWords1 = new HashSet<>();
		
		String[] nextWord;
		
		try {
			
			wordReader.readNext();
			
			
			while((nextWord = wordReader.readNext()) != null) {
				
				for (int i = 0; i < nextWord.length; i++) {	
					
					if (nextWord[i].length() >= 5) {
						if ((nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("kit")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("tor")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ion")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("zor")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ord")
							|| nextWord[i].substring(nextWord[i].length() - 4, nextWord[i].length()).equals("ards")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("sor")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("uit")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ex")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("nal")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("tar")
							|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ator")
							&& !(nextWord[i].substring(nextWord[i].length() - 4, nextWord[i].length()).equals("tion"))
							&& !(nextWord[i].substring(nextWord[i].length() - 5, nextWord[i].length()).equals("wards"))
							&& !(nextWord[i].substring(nextWord[i].length() - 2, nextWord[i].length()).equals("s")))
							)
						{
							foundWords1.add(nextWord[i]);
						}
						
						int requiredLength = 3;
						
						if (nextWord[i].length() >= requiredLength) {
							if (nextWord[i].substring(nextWord[i].length() - requiredLength, nextWord[i].length()).equals("ous")
								|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("tic")
								|| nextWord[i].substring(nextWord[i].length() - 2, nextWord[i].length()).equals("zz")
								|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ley")
								|| nextWord[i].substring(nextWord[i].length() - 3, nextWord[i].length()).equals("ex")) {
								foundWords2.add(nextWord[i]);
							}
						}
					}					
				}				
			}
			
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		
		int astroSize = foundAstroObjects.size();
		int words1Size = foundWords1.size();
		int words2Size = foundWords2.size();
		
		int astroRandIndex = rand.nextInt(astroSize);
		int words1RandIndex = rand.nextInt(words1Size);
		int words2RandIndex = rand.nextInt(words2Size);
		
		Object[] astroComponents = foundAstroObjects.toArray();
		
		String astroResult = (String)astroComponents[astroRandIndex];
		
		Object[] words1Components = foundWords1.toArray();
		Object[] words2Components = foundWords2.toArray();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		
		String wordResult1 = ((String)words1Components[words1RandIndex]);
		stringBuilder.append(wordResult1.substring(0,1).toUpperCase());
		stringBuilder.append(wordResult1.substring(1));		
		String wordResult1Formatted = stringBuilder.toString();
		
		stringBuilder.delete(0, wordResult1Formatted.length());
		
		String wordResult2 = (String)words2Components[words2RandIndex];
		stringBuilder.append(wordResult2.substring(0,1).toUpperCase());
		stringBuilder.append(wordResult2.substring(1));		
		String wordResult2Formatted = stringBuilder.toString();
		
		String  finalResult;
		stringBuilder = new StringBuilder();
		
		if (astroResult.substring(astroResult.length() - 3, astroResult.length()).equals("es")
				|| astroResult.substring(astroResult.length() - 3, astroResult.length()).equals("ers")
				|| astroResult.substring(astroResult.length() - 3, astroResult.length()).equals("fs")
				|| astroResult.substring(astroResult.length() - 3, astroResult.length()).equals("ion")
				|| astroResult.substring(astroResult.length() - 3, astroResult.length()).equals("ect")) {
			stringBuilder.append(wordResult2Formatted);
			stringBuilder.append(" ");
			stringBuilder.append(astroResult);
		}
		else {
			stringBuilder.append(wordResult2Formatted);
			stringBuilder.append(" ");
			stringBuilder.append(astroResult);
			stringBuilder.append(" ");
			stringBuilder.append(wordResult1Formatted);
		}
			
		finalResult = stringBuilder.toString();
		
		return finalResult;	
		
	}

	
	
}
