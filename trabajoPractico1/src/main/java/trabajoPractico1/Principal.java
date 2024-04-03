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

		JOptionPane.showMessageDialog(null, "Lista de alumnos: " + "\n" + armarLista(alumnos));
		JOptionPane.showMessageDialog(null, "Lista de Profesores: " + "\n" + armarLista(profesores));

		ordenarPorNombre(alumnos);
		ordenarPorLegajo(profesores);
		JOptionPane.showMessageDialog(null, "Lista de alumnos: " + "\n" + armarLista(alumnos));
		JOptionPane.showMessageDialog(null, "Lista de Profesores: " + "\n" + armarLista(profesores));

		// MAYOR Y MENOR PROMEDIO
		Alumno alumnoMax = Collections.max(alumnos, Comparator.comparing(Alumno::getPromedio));
		JOptionPane.showMessageDialog(null, "El alumno con mayor promedio es: " + alumnoMax.getNombre() + " "
				+ alumnoMax.getApellido() + ", promedio: " + alumnoMax.getPromedio());

		Alumno alumnoMin = Collections.min(alumnos, Comparator.comparing(Alumno::getPromedio));
		JOptionPane.showMessageDialog(null, "El alumno con menor promedio es: " + alumnoMin.getNombre() + " "
				+ alumnoMin.getApellido() + ", promedio: " + alumnoMin.getPromedio());

		// Lista con Promedios mayores a 7

		JOptionPane.showMessageDialog(null, "Promedios mayores a 7:\n" + rangoPromedios(alumnos));

		// Profesores ing. en sistemas
		JOptionPane.showMessageDialog(null, tituloProfesores(profesores));

		// Profesores ordenados por edad
		JOptionPane.showMessageDialog(null, edadProfesores(profesores));

	}

	// FIN MAIN

	private static<T extends Persona> String armarLista(ArrayList<T> lista) {
		String listaAux = "";

		for (T persona : lista) {
			listaAux += persona.getNombre() + " " + persona.getApellido() + "\n";

		}

		return listaAux;
	}
/*
	private static String armarListaProfesor(ArrayList<Profesor> lista) {
		String listaAux = "";

		for (Profesor persona : lista) {
			listaAux += persona.getNombre() + " " + persona.getApellido() + " " + persona.getLegajo() + " "
					+ persona.getTitulo() + "\n";

		}

		return listaAux;
	}*/

	private static void ordenarPorNombre(ArrayList<Alumno> personas) {
		Collections.sort(personas);
	}

	private static void ordenarPorLegajo(ArrayList<Profesor> persona) {
		Collections.sort(persona);
	}

	private static String rangoPromedios(ArrayList<Alumno> alumnos) {
		ArrayList<Alumno> copia = new ArrayList<Alumno>();
		double promedioTotal = 0;
		double promedioMayores = 0;
		String aux = "";
		for (Alumno alumno : alumnos) {
			promedioTotal += alumno.getPromedio();
			if (alumno.getPromedio() >= 7) {
				promedioMayores += alumno.getPromedio();
				copia.add(alumno);
			}
		}
		Alumno max = null;
		promedioMayores = Math.round((promedioMayores / copia.size()) * 100) / 100;
		promedioTotal = Math.round((promedioTotal / alumnos.size()) * 100) / 100;
		while (copia.size() > 0) {
			max = copia.get(0);
			for (int i = 0; i < copia.size(); i++) {

				if (max.getPromedio() < copia.get(i).getPromedio())
					max = copia.get(i);
			}
			aux += max.getNombre() + " " + max.getApellido() + ", Promedio: " + max.getPromedio() + "\n";
			copia.remove(max);
		}
		aux += "Promedio total de todos los alumnos: " + promedioTotal + "\n Promedio de los mejores alumnos: "
				+ promedioMayores;
		return aux;
	}

	private static String tituloProfesores(ArrayList<Profesor> profesores) {
		String lista = "Profesores con título de ing. en sistemas: \n";
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).titulo == "Ingeniero en Sistemas") {
				lista += profesores.get(i).getNombre() + " " + profesores.get(i).getApellido() + "\n";
			}
		}
		return lista;
	}

	private static String edadProfesores(ArrayList<Profesor> profesores) {
		ArrayList<Profesor> copia = new ArrayList<Profesor>();
		String aux = "Lista de profesores por edad \n";
		int totalEdad = 0;
		Profesor max = null;
		for (Profesor profesor : profesores)
			copia.add(profesor);

		while (copia.size() > 0) {
			max = copia.get(0);
			for (int i = 0; i < copia.size(); i++) {
				if (max.getEdad() < copia.get(i).getEdad())
					max = copia.get(i);
			}
			aux += max.getNombre() + " " + max.getApellido() + ", Edad: " + max.getEdad() + "\n";
			copia.remove(max);

			totalEdad += max.getEdad();
		}
		aux += "Edad total: " + totalEdad;
		return aux;
	}
}
