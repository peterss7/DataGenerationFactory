package dataresources.csvproperties;

public enum Filepaths {
	
	ZIP_CODE_MASTER(new String (
			"C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\zip-code-resource.csv")),
	USERS(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\prs-data-users.csv")),
	VENDORS(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\prs-data-vendors.csv")),
	PRODUCTS(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\prs-data-products.csv")),
	REQUESTS(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\prs-data-requests.csv")),
	REQUEST_LINES(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\prs-data-requestlines.csv")),
	STATE_DATA_CSV(new String ("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\states.csv")),
	VENDOR_TYPES_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\business-types.csv")),
	ASTRONOMY_TERMS_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\astronomy-terms.csv")),
	TEN_THOUSAND_WORDS_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\ten-thousand-words.csv")),
	CITIES_AND_STATES_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\cities-and-states-resource.csv")),
	CITIES_AND_STATES_CSV2(new String("\"C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\cities-and-states-resource.csv")),
	UNITS_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\units.csv")),
	ADVERBS_CSV(new String("C:\\Users\\peter\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\DataGenerationFactory\\src\\main\\resources\\data-sources\\adverbs.csv"));

	private final String filepath;
	
	Filepaths(String filepath) {
		this.filepath = filepath;			
	}
	
	public String getFilepath() {
		return filepath;
	}

}
