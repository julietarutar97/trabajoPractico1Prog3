package trabajoPractico1;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Generadora {

	public static void crearProfesores(int cantProfesores, ArrayList profesores) throws Exception {
		try {
			Profesor nuevoProfesor;
			Faker faker = new Faker(new Locale("es"));
			String[] profesiones = { "Ingeniero en Sistemas", "Licenciado en letras", "Técnico en Programación" };
			for (int i = 0; i < cantProfesores; i++) {
				nuevoProfesor = new Profesor(i, faker.name().lastName(), faker.name().firstName(),
						faker.number().numberBetween(30, 70), faker.number().numberBetween(15000000, 30000000),
						faker.number().numberBetween(1000, 50000), profesiones[faker.number().numberBetween(0, 2)]);
				profesores.add(nuevoProfesor);

			}
		} catch (Exception e) {
			while (profesores.size() > 0) {
				profesores.remove(0);
			}
			throw new Exception(e);
		}
	}

	public static void crearAlumnos(int cantAlumnos, ArrayList alumnos) throws Exception {
		try {
			Alumno nuevoAlumno;
			Faker faker = new Faker(new Locale("es"));
			for (int i = 0; i < cantAlumnos; i++) {
				nuevoAlumno = new Alumno(i, faker.name().lastName(), faker.name().firstName(),
						faker.number().numberBetween(18, 40), faker.number().numberBetween(30000000, 50000000),
						faker.number().numberBetween(1000, 50000), faker.number().numberBetween(1, 40),
						faker.number().randomDouble(3, 1, 10));
				alumnos.add(nuevoAlumno);
			}

		} catch (Exception e) {
			while (alumnos.size() > 0) {
				alumnos.remove(0);
			}
			throw new Exception(e);
		}

	}
}
