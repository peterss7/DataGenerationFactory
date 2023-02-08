package creation.product;

import java.util.Random;

import static dataresources.datacomponents.FileExtensions.IMAGE_EXTENSION;
import static dataresources.datacomponents.NameComponent.FIRST_NAMES;


public class PhotoPathGenerator {

	private static final String[] DRIVES = {"C:\\", "D:\\"};
	
	public static String generatePhotoPath(String vendorName, String productCode,
			String productName) {
		
		String filepath = "";
		Random rand = new Random();
		StringBuilder builder = new StringBuilder();

		if (rand.nextInt(2) == 0)
			builder.append(DRIVES[0]);
		else
			builder.append(DRIVES[1]);
		
		// "C:\Users\peter\Documents\workspace-spring-tool-suite-4-4.17.0.RELEASE\
		//  PrsSpringBoot\src\main\resources\prs-database-vendors.csv"
		
		builder.append("Users\\");
			
		String[] names = FIRST_NAMES.getArray();
		int namesLength = names.length;		
		int randNameIndex = rand.nextInt(namesLength - 1);
		String randName = names[randNameIndex];
		String nameComponent = "";
		
		if (randName.length() > 6)
			nameComponent = randName.substring(0, 6).toLowerCase();
		else
			nameComponent = randName.toLowerCase();
		
		builder.append(nameComponent);
			
		String vendorNameComponent = vendorName;
		StringBuilder vendorNameBuilder = new StringBuilder();		
		char[] vendorNameComponentChars = vendorNameComponent.toCharArray();
		
		for (char character : vendorNameComponentChars) {
			if (character == ' ' || character == '\'') vendorNameBuilder.append('-' + "");
			else vendorNameBuilder.append(character + "");
		}
		
		vendorNameComponent = vendorNameBuilder.toString().toLowerCase();
		
		builder.append(vendorNameComponent);
		
		String productCodeComponent = productCode.substring(0, productCode.indexOf('-'));
		
		builder.append(productCodeComponent + "\\");
		
		char[] productNameChars = productName.toCharArray();
		StringBuilder productNameComponentBuilder = new StringBuilder();
		
		for(char character: productNameChars) {
			if (character == ' ') productNameComponentBuilder.append('-' + "");
			else productNameComponentBuilder.append(character);
		}
		
		String productNameComponent = productNameComponentBuilder.toString().toLowerCase();
		
		builder.append(productNameComponent);
		
		String [] extensions = IMAGE_EXTENSION.getExtensions();
		int extensionsSize = extensions.length;
		int extensionRandIndex = rand.nextInt(0, extensionsSize - 1);
		String randExtension = extensions[extensionRandIndex];
		
		builder.append(randExtension);
		
		return builder.toString().toLowerCase();
	}
	
	
}
