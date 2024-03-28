package trabajoPractico1;

public class Profesor extends Persona {
	Integer legajo;
	String titulo;

	public Integer getLegajo() {
		return legajo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Profesor(Integer id, String apellido, String nombre, Integer edad, Long dni, Integer legajo, String titulo) {
		super(id, apellido, nombre, edad, dni);
		this.legajo = legajo;
		this.titulo = titulo;
	}

}
