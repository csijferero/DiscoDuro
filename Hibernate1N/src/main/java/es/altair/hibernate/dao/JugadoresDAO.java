package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Jugador;

public interface JugadoresDAO {
	
	public void guardar(Jugador j);
	public void modificar(Jugador j);
	public Jugador obtener (int id);
	public void borrar(Jugador j);


}
