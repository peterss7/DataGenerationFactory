package creation.common.common_strings;

import utilities.BetterRand;

import java.util.Random;


public class CodeGenerator {
	


	public static String getCode(String codeAddon) {

    	String vendorCode = null;
    	
    	int charStringLength = BetterRand.randInRange(5, 8);
    	int numberRangeIndex1 = BetterRand.randInRange(1, 4);
    	int numberRangeIndex2 = BetterRand.randInRange(1, 3);
		
    	StringBuilder builder = new StringBuilder();
    	StringBuilder builderAux = new StringBuilder();
    	    	
		int prefixOrSuffixDeterminer = BetterRand.randInRange(0, 100);
		int randomizedOrderNumber = BetterRand.randInRange(0, 2);;
		int partOneMultiplier = 10;
		boolean isPrefix = false;
		
		if (prefixOrSuffixDeterminer > 50) isPrefix = true;
		
		
		
		switch ((randomizedOrderNumber)) {
			case 0: 
				builder.append(getPartOne(numberRangeIndex1,partOneMultiplier) + "-");
				builder.append(getRandomChars(charStringLength).toUpperCase() + "-");
				builder.append(getPartThree(numberRangeIndex2));
				// Console.print("ONE: " + builder.toString() + ", ");
				break;
			case 1:
				builder.append(getRandomChars(charStringLength).toUpperCase() + "-");
				builder.append(getPartThree(numberRangeIndex2) + "-");
				builder.append(getPartOne(numberRangeIndex1, partOneMultiplier));
				// Console.print("TWO: " + builder.toString() + ", ");
				break;
			case 2:
				builder.append(getPartThree(numberRangeIndex2) + "-");
				builder.append(getPartOne(numberRangeIndex1, partOneMultiplier) + "-");
				builder.append(getRandomChars(charStringLength).toUpperCase());
				// Console.print("THREE: " + builder.toString() + ".\n");
				break;
			default:
				builder.append("failed-to-generate-product-code " + randomizedOrderNumber);
				break;		
		}
		
		
				
		if (!(codeAddon.equals(""))){
				
				if (isPrefix) {
					builderAux.append(codeAddon + "-");
					builderAux.append(builder.toString());
					vendorCode = builderAux.toString();
				}
				else if (!isPrefix)  {
					builder.append("-" + codeAddon);
					vendorCode = builder.toString();
				}
				
				if (vendorCode.equals(null)) {
					vendorCode = "12345";
				}
			
		}
		else {
			vendorCode = builder.toString();
		}
		
		return vendorCode;

	}
	
	private static String getPartOne(int numberRangeIndex1, int multiplier) {
		
		String result = "";
		
		switch (numberRangeIndex1){
		case 1: 
			result += BetterRand.randInRange(100, 999) * multiplier + "";
			break;
		case 2:
			result += BetterRand.randInRange(1000, 9999) * multiplier + "";
			break;
		case 3:
			result += BetterRand.randInRange(10000, 99999) * multiplier + "";
			break;
		case 4:	
			result += BetterRand.randInRange(100000, 999999) * multiplier + "";
			break;
		}
		return result;
	}
	
	public static String getPartThree(int numberRangeIndex2) {

		String result = "";
		
    	switch (numberRangeIndex2){
			case 1: 
				result += BetterRand.randInRange(100, 999);
				break;
			case 2:
				result += BetterRand.randInRange(1000, 9999) + "";
				break;
			case 3:
				result += BetterRand.randInRange(1000, 9999) + "";
				break;			
    	}
    	
    	return result;
	}
	
	public static String getRandomChars(int length) {
		
		Random rand = new Random();
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		while(count < length) {
			builder.append((char) BetterRand.randInRange(65, 90));
			count++;
		}
		
		return builder.toString();
		
	}
	
}
