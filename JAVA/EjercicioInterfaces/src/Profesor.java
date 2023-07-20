
public class Profesor implements IPersona{
	private String nombre;
	private float salario;
	
	
	
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	@Override
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	
	
	
}
