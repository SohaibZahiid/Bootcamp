
public class Car {
	private float fuel;
	private float maxSpeed;
	
	public Car(float fuel, float maxSpeed) {
		super();
		this.fuel = fuel;
		this.maxSpeed = maxSpeed;
	}

	public Car() {
		super();
	}

	public void drive() {
		System.out.println("DRIVING...");
	}
	
	public float getFuel() {
		return fuel;
	}
	public void setFuel(float fuel) {
		this.fuel = fuel;
	}
	public float getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	
}
