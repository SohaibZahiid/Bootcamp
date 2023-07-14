
public class Main {

	public static void main(String[] args) {
		
	
		for (int i = 0; i < 10; i++) {
			
			for (int j = 10; j >= i; j--) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("\033[102m* \033[0m");
			}
			System.out.println();
			
			
		}
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= 8; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 4; j++) {
				System.out.print("\033[100m*\033[0m");
			}

			System.out.println();
		}
		
	}

}
