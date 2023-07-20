import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce boolean");
		boolean bool = sc.nextBoolean();
		
		System.out.println("Introduce string");
		String str = sc.next();
		
		System.out.println("Introduce int");
		int num = sc.nextInt();
		
		System.out.println(bool);
		System.out.println(str);
		System.out.println(num);
	}
}
