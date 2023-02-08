package utilities;

public class Console {

	public static void print(String input) {
		System.out.print(input);
	}
	
	public static void print(int input) {
		System.out.print(input + "");
	}

	public static void print(char input) {
		System.out.print(input + "");
	}
	
	public static void print(boolean input) {
		System.out.print(String.valueOf(input));
	}
	
	public static void println(String input) {
		System.out.println(input);
	}
	
	public static void println(int input) {
		System.out.println(input + "");
	}

	public static void println(char input) {
		System.out.println(input + "");
	}
	
	public static void println(boolean input) {
		System.out.println(String.valueOf(input));
	}
	
}
