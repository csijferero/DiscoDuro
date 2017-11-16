package dao;

import java.util.ArrayList;

import bin.Palabra;

public interface PalabrasDAO {
	
	public Boolean incluirPalabra(Palabra p);
	public Boolean incluirfrase(ArrayList<Palabra> palabras);
	
	public void listarPalabrasNuevas();
	public void listarPalabrasRepetidas();
	
	

}
