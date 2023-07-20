
public class Alumno implements IPersona{
	private String nombre;
	private String curso;
	
	
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
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
