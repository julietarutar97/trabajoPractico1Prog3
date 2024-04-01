package trabajoPractico1;

import java.util.*;

import javax.swing.JOptionPane;

import com.github.javafaker.Faker;

public class Principal {

	public static void main(String[] args) {

		final int cantAlumnos = 50;
		final int cantProfesores = 20;

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();

		try {
			Generadora.crearAlumnos(cantAlumnos, alumnos);
		} catch (Exception e) {

			System.out.println("No se pudieron crear los Alumnos:\n" + e);

		}

		try {
			Generadora.crearProfesores(cantProfesores, profesores);
		} catch (Exception e) {

			System.out.println("No se pudieron crear los Profesores:\n" + e);

		}

		JOptionPane.showMessageDialog(null, "Lista de alumnos: " + "\n" + armarListaAlumnos(alumnos));
		JOptionPane.showMessageDialog(null, "Lista de Profesores: " + "\n" + armarListaProfesor(profesores));

		ordenarPorNombre(alumnos);
		ordenarPorLegajo(profesores);
		JOptionPane.showMessageDialog(null, "Lista de alumnos: " + "\n" + armarListaAlumnos(alumnos));
		JOptionPane.showMessageDialog(null, "Lista de Profesores: " + "\n" + armarListaProfesor(profesores));

		// MAYOR Y MENOR PROMEDIO
		Alumno alumnoMax = Collections.max(alumnos, Comparator.comparing(Alumno::getPromedio));
		JOptionPane.showMessageDialog(null, "El alumno con mayor promedio es: " + alumnoMax.getNombre() + " "
				+ alumnoMax.getApellido() + ", promedio: " + alumnoMax.getPromedio());

		Alumno alumnoMin = Collections.min(alumnos, Comparator.comparing(Alumno::getPromedio));
		JOptionPane.showMessageDialog(null, "El alumno con menor promedio es: " + alumnoMin.getNombre() + " "
				+ alumnoMin.getApellido() + ", promedio: " + alumnoMin.getPromedio());

		//Lista con Promedios mayores a 7
		
		JOptionPane.showMessageDialog(null,"Promedios mayores a 7:\n" + rangoPromedios(alumnos));
	
	}

	private static String armarListaAlumnos(ArrayList<Alumno> lista) {
		String listaAux = "";

		for (Alumno persona : lista) {
			listaAux += persona.getNombre() + " " + persona.getApellido() + "\n";

		}

		return listaAux;
	}

	private static String armarListaProfesor(ArrayList<Profesor> lista) {
		String listaAux = "";

		for (Profesor persona : lista) {
			listaAux += persona.getNombre() + " " + persona.getApellido() + " " + persona.getLegajo() + " "
					+ persona.getTitulo() + "\n";

		}

		return listaAux;
	}

	private static void ordenarPorNombre(ArrayList<Alumno> personas) {
		Collections.sort(personas);
	}

	private static void ordenarPorLegajo(ArrayList<Profesor> persona) {
		Collections.sort(persona);
	}

	private static String rangoPromedios(ArrayList<Alumno> alumnos) {
		ArrayList<Alumno> copia = new ArrayList<Alumno>();
		String aux = "";
		/*
		 * for (int i = 0; i < alumnos.size(); i++) { if (alumnos.get(i).getPromedio() >
		 * 6) { copia.add(alumnos.get(i)); } } for (int i = 1; i < copia.size(); i++) {
		 * if(copia.get(i).getPromedio()>copia.get(i-1).getPromedio()) {
		 * 
		 * } }
		 */

		for (Alumno alumno : alumnos)
			if (alumno.getPromedio() >= 7)
				copia.add(alumno);

		Alumno max = null;
		while(copia.size()>0) {
			max = copia.get(0);
			for(int i=0;i<copia.size();i++) {
				if(max.getPromedio()< copia.get(i).getPromedio()) max = copia.get(i);
			}
			aux += max.getNombre() + " " + max.getApellido() + ", Promedio: " + max.getPromedio() + "\n";
			copia.remove(max);
		}
		
		return aux;
	}

	/*
	 * private static void identificarPromedio(ArrayList<Persona> persona) {
	 * double[] Promedios = -1;
	 * 
	 * return Promedios; }
	 */
}
