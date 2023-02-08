package dataresources.datacomponents;

public enum VendorComponent {

	NOUNS(new String[] {"physics","requirement","bath","profession",
			"throat","wife","revenue","permission","charity","secretary","diamond",
			"entertainment","assumption","opportunity","replacement","information",
			"weakness","farmer","media","reputation","hospital","tradition","artisan",
			"tension","salad","wood","beer","user","philosophy","bedroom","fortune",
			"engine","reality","outcome","climate","shirt","poetry","uncle","skill",
			"topic","disease","response","desk","tennis","death","flight","idea","people",
			"estate","collection","Wish Crane", "exception", "handler", "client", "screener"
			}),
	VERBS(new String[] {"travel","impress","store","praise","collect",
			"convince","decorate","instruct","arrest","agree","quote","gasp","improve",
			"form","fancy","receive","understand","develop","swing","weaken","chat","pay",
			"release","judge","question","exceed","copy","confess","hurry","know","serve",
			"fund","target","spring","strengthen","benefit","test","precede","dedicate",
			"brainstorm","slam","protect","select","prevent","insert","suffer","attach",
			"twist","step","look", "void", "shadow" ,"hollow", "seeing", "eyeballing", "slammer",
			"throw", "catch"});	

	private final String[] words;
	
	VendorComponent(String[] words) {
		this.words = words;
	}
	
	public String[] getWords() {
		return words;	
	}
	
	
}
