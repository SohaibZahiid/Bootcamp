
public class Main {
	public static void main(String[] args) {
		final String RESET = "\033[0m";
		
		
		// UKRAINE
		System.out.println(RESET +"\033[1;4mUKRAINE" + RESET);
		print((color(0, 0, 255) + spaces(18)), true);
		print((color(0, 0, 255) + spaces(18)), true);
		print((color(255, 255, 0) + spaces(18)), true);
		print((color(255, 255, 0) + spaces(18)), true);
		
		System.out.println("\n");
		
		//FRANCE
		System.out.println(RESET +"\033[1;4mFRANCE" + RESET);
		print((color(0, 0, 255) + spaces(6)), false);
		print((color(255, 255, 255) + spaces(6)), false);
		print((color(255, 0, 0) + spaces(6)), true);
		print((color(0, 0, 255) + spaces(6)), false);
		print((color(255, 255, 255) + spaces(6)), false);
		print((color(255, 0, 0) + spaces(6)), true);
		print((color(0, 0, 255) + spaces(6)), false);
		print((color(255, 255, 255) + spaces(6)), false);
		print((color(255, 0, 0) + spaces(6)), true);
		print((color(0, 0, 255) + spaces(6)), false);
		print((color(255, 255, 255) + spaces(6)), false);
		print((color(255, 0, 0) + spaces(6)), true);
		
		System.out.println("\n");
		
//		SPAIN
		System.out.println(RESET +"\033[1;4mSPAIN" + RESET);
		print(color(255, 0, 0) + spaces(18), true);
		print(color(255, 255, 0) + spaces(18), true);
		print(color(255, 255, 0) + spaces(18), true);
		print(color(255, 0, 0) + spaces(18), true);
		
		System.out.println("\n");
	
		//GERMANY
		System.out.println(RESET +"\033[1;4mGERMANY" + RESET);
		print(color(0, 0, 0) + spaces(18), true);
		print(color(255, 0, 0) + spaces(18), true);
		print(color(255, 255, 0) + spaces(18), true);
		
	}
	
	
	
	public static String color(int red, int green, int blue) {
		return "\033[48;2;" + red + ";" + green + ";" + blue + "m";
	}
	
	public static String spaces(int numberOfSpaces) {
		String spaces = "";
		for (int i = 0; i < numberOfSpaces; i++) {
			spaces += " "; 
		}
		return spaces;
	}
	
	public static void print(String draw, boolean nextLine) {
		if(nextLine == true) {
			System.out.println(draw);
		} else {
			System.out.print(draw);
		}
	}
}
