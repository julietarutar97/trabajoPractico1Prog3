package trabajoPractico1;

public class Alumno extends Persona {
	Integer nroLegajo;
	Integer materiasAprobadas;
	double promedio;

	public Integer getNroLegajo() {
		return nroLegajo;
	}

	public Integer getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public double getPromedio() {
		return promedio;
	}

	public Alumno(Integer id, String apellido, String nombre, Integer edad, long dni, Integer nroLegajo,
			Integer materiasAprobadas, double promedio) {
		super(id, apellido, nombre, edad, dni);
		this.nroLegajo = nroLegajo;
		this.materiasAprobadas = materiasAprobadas;
		this.promedio = promedio;
	}

}
