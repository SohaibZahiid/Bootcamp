
public class Car {
	private String company;
	private int speed;
	
	public Car() {
		
	}
	
	public Car(String company, int speed) {
		super();
		this.company = company;
		this.speed = speed;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public void speed() {
		System.out.println(this.company + " car speed is " + this.speed + " km/h");
	}
	
}
