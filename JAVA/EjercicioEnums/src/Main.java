
public class Main {
	public static void main(String[] args) {
		Developer dev1 = new Developer("Sohaib", "Zahid", 23, "12345678G", Profesiones.FULLSTACK);
		Developer dev2 = new Developer("Keanu", "Reeves", 59, "32412454E", Profesiones.FRONTEND);
		Developer dev3 = new Developer("Tom", "Cruise", 61, "45654321R", Profesiones.BACKEND);
		
		Developer[] devs = {dev1, dev2, dev3};
		
		for (Developer developer : devs) {
			
			System.out.println(developer);
			
			if(developer.getRole().equals(Profesiones.BACKEND)) {
				System.out.println("Viva el back");
			} else {
				System.out.println("JS es 💩 mejor utilizar TypeScript");
			}
		}
	}
}
