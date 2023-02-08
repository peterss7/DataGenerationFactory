package dataresources.csvproperties;

public enum Headers {
	
	USER_HEADERS(new String[]{"Id", "Username", "Password", "FirstName",
		"LastName", "PhoneNumber", "Email","IsReviewer", "IsAdmin"}),
	VENDOR_HEADERS(new String[] {"Id", "Code", "Name", "Address", "City",
		"State", "Zip", "Phone","Email"}),
	PRODUCT_HEADERS(new String[] {"Id", "PartNumber", "Name", "Price", "Unit", "Photopath", "VendorId"}),
	REQUEST_HEADERS(new String[] {"Id", "Description", "Justification", "RejectionReason",
			"DeliveryMode", "SubmittedDate", "DateNeeded", "Status", "Total", "UserId"}),
	REQUEST_LINE_HEADERS(new String[] {"Id", "RequestId", "ProductId", "Quantity"});
	
	private String[] headers;
	
	Headers (String[] headers){
		this.headers = headers;
	}
	
	public String[] getHeaders() {
		return headers;
	}
}
