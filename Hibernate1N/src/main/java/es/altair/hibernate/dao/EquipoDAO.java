package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Equipo;

public interface EquipoDAO {
	
	public void guardar(Equipo e);
	public Equipo obtener (int id);
	public void modificar(Equipo e);
	public void borrar(Equipo e);

}
