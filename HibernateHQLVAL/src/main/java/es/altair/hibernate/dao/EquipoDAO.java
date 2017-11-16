package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Equipo;

public interface EquipoDAO {

	public List<Equipo> listado();

	public List<Equipo> listadoNombreySocios();
	
	public Equipo obtener(int i);


	public Equipo obtenerCS(String ciudad, int numSocio);

	public List<Equipo> listadoPorSocios(int num);

}
