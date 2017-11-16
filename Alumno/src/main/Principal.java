package main;

import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import bean.Alumno;
import dao.AlumnoDAO;
import dao.AlumnoDAOImplListas;
import dao.AlumnoDaoImplConj;

public class Principal {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		//AlumnoDAO alumnoDAO = new AlumnoDAOImplListas();
		AlumnoDAO alumnoDAO = new AlumnoDaoImplConj();
		
		Alumno a1 = new Alumno("n1", "ap1", 22, 3.4F);
		Alumno a2 = new Alumno("n2", "ap2", 23, 3.4F);
		Alumno a3 = new Alumno("n3", "ap3", 24, 3.4F);
		
		alumnoDAO.anadirAlumno(a1);
		alumnoDAO.anadirAlumno(a2);
		alumnoDAO.anadirAlumno(a3);
		
		System.out.println("Nombre");
		String nombre = sc.next();
		System.out.println("El alumno con nombre igual a " + nombre + " es " + alumnoDAO.buscaPorNombre(nombre));
		
		System.out.println("Edad");
		Integer edad = sc.nextInt();
		System.out.println("El alumno con edad igual a " + edad + " es " + alumnoDAO.buscaPorEdad(edad));
		
		System.out.println("Patron");
		String patron = sc.next();
		System.out.println("El alumno con algo igual a " + patron + " es " + alumnoDAO.busca(patron));
		
		
		sc.close();
	}

}
