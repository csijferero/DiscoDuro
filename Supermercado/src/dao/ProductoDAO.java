package dao;

import bean.Producto;

public interface ProductoDAO {
	
	public void anadiranadir(Producto p);
	public Boolean borar (Integer codigo);
	public Boolean actualizar (Producto p);
	public void listar();
	public void borrarTodos();
	
	public void generarFichero(String nombreFichero);
	public void recuperarFichero(String nombreFichero);

}
