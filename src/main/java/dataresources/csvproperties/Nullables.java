package dataresources.csvproperties;

public enum Nullables {
	USER_NULLABLES(new int[]{5,6,9}),
	VENDOR_NULLABLES(new int[] {5,7,8}),
	REQUEST_NULLABLES(new int[] {2}),
	PRODUCT_NULLABLES(new int[] {5}),
	REQUEST_LINE_NULLABLES(new int [] {});
	
	private int[] nullables;
	
	Nullables (int[] nullables){
		this.nullables = nullables;
	}
	
	public int[] getNullables() {
		return nullables;
	}
}
