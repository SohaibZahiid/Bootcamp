import java.util.Date;

public class Card {
	private String owner;
	private long number;
	private float credits;
	private String entity;
	private Date valid;
	private boolean active;

	public Card() {
		super();
	}

	public Card(String owner, float credits, long number, String entity, Date valid, boolean active) {
		super();
		this.owner = owner;
		this.credits = credits;
		this.number = number;
		this.entity = entity;
		this.valid = valid;
		this.active = active;
	}

	public void activate(boolean active) {
		this.active = true;
	}

	public void pay(float price) {
		if (this.active && price <= this.credits) {
			System.out.println("PAYING...");
			this.credits -= price;
		} else if (price > this.credits) {
			System.out.println("YOU DONT HAVE THE CREDITS");
		} else {
			System.out.println("YOUR CARD IS NOT ACTIVE");
		}
	}

	public float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Date getValid() {
		return valid;
	}

	public void setValid(Date valid) {
		this.valid = valid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Card [owner=" + owner + ", number=" + number + ", entity=" + entity + ", valid=" + valid + ", active="
				+ active + "]";
	}

}
