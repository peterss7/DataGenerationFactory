package creation.product;


import creation.common.common_strings.CodeGenerator;

import java.util.Random;

public class PartNumberGenerator {

	public static String generatePartNumber(String name) {
		
		String partNumber = "";		
		
		// Console.println("name in getPartNumber method: " + name);
		
		String partNumberAddon = getAddon(name);
		
		// Console.println("partNumberAddon in getPartNumber method: " + partNumberAddon);
		
		// System.out.println("partNumberAddon in getPartNumber method: " + partNumberAddon);
		
		partNumber = CodeGenerator.getCode(partNumberAddon);
		
		return partNumber;
		
	}
	
    public static String getAddon(String name) {
    	
    	String result = "";
    	
    	if (name.indexOf(" ") > 4 && name.length() > 5) {
    		result = name.substring(0, (new Random().nextInt(3, name.indexOf(" ") - 1))).toUpperCase();
    	}
    	else if (name.length() > 2){
    		result = name.substring(0, (new Random().nextInt(3, name.indexOf(" ") - 1))).toUpperCase();
    	}
    	else result = "SPECIAL";
    	
    	// Console.println("name is: " + name);
    	// Console.println("result is: " + result);
    	
    	// ((new StringBuilder()).append(result.substring(0, (new Random()).nextInt(3,  8)))).toString();
    	
    	return result; 
    	
    }
	
}
