package creation.product;


import utilities.BetterRand;

import static dataresources.csvproperties.TableSizes.VENDORS_SIZE;


public class VendorIdGenerator {

	public static String generateVendorId() {
		
		String vendorId = "";
		
		vendorId = BetterRand.randInRange(1, VENDORS_SIZE.getSize()) + "";
		
		return vendorId;
	}
	
}
