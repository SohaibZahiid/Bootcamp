import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
//		EJERCICIO CONCATENACION STRINGS
		
//		String nombre = "Sohaib", apellidos = "Zahid", 
//		calle = "Ronda Torrassa", municipio = "Hospitalet", codigoPostal = "08903";
//		char sexo = 'H';
//		
//		System.out.println(nombre + " " + apellidos + " " + sexo + "\n" + calle + " " + municipio + 
//				" " + codigoPostal);
		
		
//		EJERCICIO OPERADORES ARITMETICOS
		
//		System.out.println(10 - 5);
//		System.out.println(55 + 45);
//		System.out.println(-3);
//		System.out.println(5 * 5);
//		
//		int num1 = 25, num2 = 7;
//		int resultado = num1 / num2;
//		float resultado2 = (float) num1 / num2;
//		System.out.println(resultado);
//		System.out.println(resultado2);
		
//		System.out.println(25 % 4);
		
		
		
//		EJERCICIO OPERADORES ARITMETICOS INCREMENTALES
		
//		int num = 0;
//		num = increment(num);
//		num = increment(num);
//		num = increment(num);
//		num = increment(num);
//		System.out.println(num);
//		
//		num = decrement(num);
//		num = decrement(num);
//		num = decrement(num);
//		System.out.println(num);
		
		
		
//		EJERCICIO OPERADORES ARITMETICOS COMBINADOS
		
//		int num = 25;
//		num+= 5;
//		num-=15;
//		num*=2;
//		num/=2;
//		num%=3;
//		System.out.println(num);
		
		
		
//		EJERCICIO OPERADORES LOGICOS/BOOLEAN
		
//		System.out.println("Pon un numero: ");
//		int num = sc.nextInt();
//		
//		if(num%2==0) {
//			System.out.println("Par");
//		} else {
//			System.out.println("Impar");
//		}
		
		
		boolean num = r.nextBoolean();
		if(num) {
			System.out.println("Blanco");
		} else {
			System.out.println("Negro"); 
			
		}
		
		
	}
	
//	public static int increment(int num) {
//		
//		return num = num + 1;
//	}
//	
//	public static int decrement(int num) {
//		return num = num - 1;
//	}
	
}
