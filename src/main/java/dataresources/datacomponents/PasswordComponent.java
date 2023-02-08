package dataresources.datacomponents;

public enum PasswordComponent {
	
	SPECIAL_CHARACTERS(new char [] {'!', '@', '#', '$', '%', '^', '*', '(', ')'});

	private final char[] array;
	
	PasswordComponent(char[] array) {
		this.array = array;			
	}
	
	public char[] getArray() {
		return array;
	}
}
