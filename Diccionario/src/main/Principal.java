package main;

import bin.Diccionario;
import dao.DiccionarioDAO;
import dao.DiccionarioDAOImplConj;

public class Principal {

	public static void main(String[] args) {
		//DiccionarioDAO diccionarioDAO = new DiccionarioImplMap();
		DiccionarioDAO diccionarioDAO = new DiccionarioDAOImplConj();

		Diccionario p1 = new Diccionario("hola", "saludo formal");
		Diccionario p2 = new Diccionario("adios", "despedida formal");
		Diccionario p3 = new Diccionario("mesa", "recipiente para colocar cosas");
		
		diccionarioDAO.anadir(p1);
		diccionarioDAO.anadir(p2);
		diccionarioDAO.anadir(p3);

		diccionarioDAO.listar();

		if (diccionarioDAO.borrar(p3))
			System.out.println("Palabra borrada");
		else
			System.out.println("Palabra no borrada");

		diccionarioDAO.listar();

		if (diccionarioDAO.buscar(p2))
			System.out.println("Palabra encontrada");
		else
			System.out.println("Palabra no encontrada");

		System.out.println("Definición de Hola: " + diccionarioDAO.obtenerDefinicion("hola"));
	}

}