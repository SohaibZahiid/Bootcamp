
public class Developer {
	

	private String name;
	private String surname;
	private int age;
	private String dni;
	private Profesiones role;

	public Developer() {
		super();
	}

	public Developer(String name, String surname, int age, String dni, Profesiones role) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dni = dni;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Profesiones getRole() {
		return role;
	}

	public void setRole(Profesiones role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Developer [name=" + name + ", surname=" + surname + ", age=" + age + ", dni=" + dni + ", role=" + role
				+ "]";
	}

}
