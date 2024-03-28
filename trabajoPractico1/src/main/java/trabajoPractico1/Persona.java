package trabajoPractico1;

public class Persona {
	Integer id;
	String apellido;
	String nombre;
	Integer edad;
	Long dni;

	public Integer getId() {
		return id;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public Long getDni() {
		return dni;
	}

	public Persona(Integer id, String apellido, String nombre, Integer edad, Long dni) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

}
