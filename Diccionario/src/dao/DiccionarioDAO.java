package dao;

import bin.Diccionario;

public interface DiccionarioDAO {

	public void anadir(Diccionario p);
	public Boolean borrar(Diccionario p);
	public Boolean buscar(Diccionario p);
	public String obtenerDefinicion(String Diccionario);
	public void listar();

}