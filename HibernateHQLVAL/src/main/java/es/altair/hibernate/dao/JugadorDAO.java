package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Equipo;
import es.altair.hibernate.bean.Jugador;

public interface JugadorDAO {

	public List<Jugador> listado();

	public void mostrarJugadoresPaginacion(int i);

}
