package main;

import java.util.ArrayList;

import bin.Palabra;
import dao.PalabrasDAO;
import dao.PalabrasDAOImpConj;

public class Principal {

	public static void main(String[] args) {
		PalabrasDAO paDAO = new PalabrasDAOImpConj();
		
		Palabra p1 = new Palabra("hola", "espa�ol");
		Palabra p2 = new Palabra("adios", "espa�ol");
		Palabra p3 = new Palabra("hello", "ingl�s");
		Palabra p4 = new Palabra("bye", "ingl�s");
		Palabra p5 = new Palabra("hola", "espa�ol");
		
		if (paDAO.incluirPalabra(p1))
			System.out.println(p1.getPalabra() + ": NUEVA");
		else
			System.out.println(p1.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p2))
			System.out.println(p2.getPalabra() + ": NUEVA");
		else
			System.out.println(p2.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p3))
			System.out.println(p3.getPalabra() + ": NUEVA");
		else
			System.out.println(p3.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p4))
			System.out.println(p4.getPalabra() + ": NUEVA");
		else
			System.out.println(p4.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p5))
			System.out.println(p5.getPalabra() + ": NUEVA");
		else
			System.out.println(p5.getPalabra() + ": REPETIDA");
		
		ArrayList<Palabra> frase = new ArrayList<>();
		frase.add(new Palabra("hola", "espa�ol"));
		frase.add(new Palabra("que", "espa�ol"));
		frase.add(new Palabra("tal", "espa�ol"));
		
		if (paDAO.incluirfrase(frase))
			System.out.println(frase.toString() + ": NUEVAS");
		else
			System.out.println(frase.toString() + ": ALGUNA REPETIDA");
		
	}

}