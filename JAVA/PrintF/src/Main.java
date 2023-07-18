
public class Main {

	public static void main(String[] args) {
		// 1--
		System.out.printf("%-12s %12s %12s \n", "SOHAIB", "MUHAMMAD", "ZAHID");
		// 2--
		System.out.printf("%-12s %12s %-12s \n", "SOHAIB", "MUHAMMAD", "ZAHID");
		// 3--
		System.out.printf("%3$s %2$s %1$s \n", "SOHAIB", "MUHAMMAD", "ZAHID");
		// 4--
		System.out.printf("%10d \n", 22);
		// 5--
		System.out.printf("%010d \n", 22);
		// 6--
		System.out.printf("%010f \n", 17.1829327);
		// 7--
		System.out.printf("%s%s \n", "Hola", "Mundo");
	}

}
