package trabajoPractico1;

import java.util.*;


import com.github.javafaker.Faker;

public class Principal {

	public static void main(String[] args) {
		
		
		final int cantAlumnos = 50;
		final int cantProfesores = 20;

		ArrayList<Persona> alumnos = null;
		ArrayList<Profesor> profesores = null;

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
		
		String listaAlumnos = armarLista((ArrayList<Persona>)alumnos);
		
		
		
		System.out.println("Lista de alumnos:" + listaAlumnos);

	}

	private static String armarLista(ArrayList<Persona> lista) {
		String listaAux = "";
		
		for(Persona persona: lista){
			listaAux+=persona.getNombre() + " " + persona.getApellido() + "\n";
			
		}
		
		return listaAux;
	}
	
	private static void ordenarPorNombre(ArrayList<Persona> personas) {
		Collections.sort(personas);
	}
	
	private static void ordenarPorLegajo(ArrayList<Profesor> persona) {
		Collections.sort(persona);
	}
	
	/*private static void  identificarPromedio(ArrayList<Persona> persona) {
		double[] Promedios = -1;
		
		return Promedios;
	}*/
	}


