package trabajoPractico1;

import java.util.*;

public class Persona implements Comparator<Persona>, Comparable<Persona> {
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

	@Override
	public int compareTo(Persona o) {
		return (this.apellido).compareTo(o.apellido);
	}

	@Override
	public int compare(Persona o1, Persona o2) {
		if (o1.getApellido() != o2.getApellido()) {
			return o1.getApellido().compareTo(o2.getApellido());
		} else
			return o1.getNombre().compareTo(o2.getNombre());
	}

}
