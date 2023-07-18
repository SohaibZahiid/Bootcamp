import java.util.Date;

public class Main {

	public static void main(String[] args) {
//		Car car1 = new Car();
//		
//		car1.setFuel(20);
//		car1.setMaxSpeed(520);
//		
//		System.out.println(car1.getFuel() + " " + car1.getMaxSpeed());
//		
//		Car car2 = new Car(50, 120);
//		System.out.println(car2.getFuel() + " " + car2.getMaxSpeed());
//		
//		Car car3 = new Car(5, 180);
//		System.out.println(car3.getFuel() + " " + car3.getMaxSpeed());
		
		
		Card card1 = new Card("Sohaib", 100, 123456789, "LACAIXA", new Date(12, 05, 2028), false);
		System.out.println(card1);
		card1.pay(50);
		System.out.println("YOUR CREDITS: " + card1.getCredits());
		
		System.out.println("\nAfter Activating the card");
		card1.activate(true);
		card1.pay(50);
		System.out.println("YOUR CREDITS: " + card1.getCredits());
		
		System.out.println("\nPaying more credits than I have");
		card1.pay(101);
		System.out.println("YOUR CREDITS: " + card1.getCredits());
	}

}
