import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int[][] BOXES = new int[3][3]; 
		
		draw(BOXES);
		
		System.out.println("1. Humano contra humano");
		System.out.println("2. Humano contra CPU (El CPU juega como 0)");
		System.out.println("3. CPU contra CPU");
		
		int option = sc.nextInt();
		
		
		switch (option) {
		case 1: {
			System.out.println("***Humano contra humano***");
			humanVhuman();
			break;
		}
		case 2: {
			System.out.println("***Humano contra CPU***");
		}
		case 3: {
			System.out.println("***CPU contra CPU***");
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	
	private static void humanVhuman() {
		Random r = new Random();
		int random = r.nextInt(2);
		
		char playerTurn = random == 0 ? 'X' : 'O';

		
		System.out.println("El jugador que inicia es: " + playerTurn);
		
	}

	public static void draw(int[][] boxes) {
		for (int i = 0; i < boxes.length; i++) {
			System.out.print("|");
			System.out.print("O");
			System.out.print("|");
			for (int j = 1; j < boxes[i].length; j++) {
				System.out.print("|");
				System.out.print("X");
				System.out.print("|");
			}
			System.out.println("");
		}
	}
}
