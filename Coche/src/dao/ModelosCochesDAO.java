package dao;

import bean.ModeloCoche;

public interface ModelosCochesDAO {
	
	public void insertarCoche(ModeloCoche c);
	public boolean actualizarCoche(ModeloCoche mcOld, ModeloCoche mcNew);
	public boolean borrarCoche(ModeloCoche c);
	public void listarCoche();


}
