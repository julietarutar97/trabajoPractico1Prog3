package trabajoPractico1;

import java.util.Comparator;

public class Profesor extends Persona implements Comparator<Persona>, Comparable<Persona> {
	Integer legajo;
	String titulo;

	public Integer getLegajo() {
		return legajo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Profesor(Integer id, String apellido, String nombre, Integer edad, long dni, Integer legajo, String titulo) {
		super(id, apellido, nombre, edad, dni);
		this.legajo = legajo;
		this.titulo = titulo;
	}

	public int compareTo(Persona o) {
		Profesor paramProf = (Profesor) o;
		return this.legajo - paramProf.legajo;
	}

}
