package es.altair.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import es.altair.hibernate.bean.Equipo;
import es.altair.hibernate.bean.Jugador;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImplHibernate;
import es.altair.hibernate.dao.JugadoresDAO;
import es.altair.hibernate.dao.JugadoresDAOImpHibernate;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		EquipoDAO equipoDAO = new EquipoDAOImplHibernate();
		JugadoresDAO jugDAO = new JugadoresDAOImpHibernate();

		// //OBTENER EQUIPO
		//
		// Equipo obtenido = equipoDAO.obtener(1);
		//
		// System.out.println(obtenido.getNombre());

		// OBTENER JUGADOR

		Jugador obtenido = jugDAO.obtener(1);

		System.out.println(obtenido.getNombre());

		// //MODIFICAR EQUIPO
		//
		// obtenido.setNombre("Betis2");
		//
		// equipoDAO.modificar(obtenido);
		//
		// System.out.println(obtenido.getNombre());

		// //MODIFICAR JUGADOR
		//
		// obtenido.setNombre("JugAct");
		//
		// jugDAO.modificar(obtenido);
		//
		// System.out.println(obtenido.getNombre());

		// // AÑADIR EQUIPO
		//
		// Equipo betis = new Equipo("Betis", "Sevilla", 123456);
		// Jugador j1 = new Jugador("Jug1", "Del", betis);
		//
		// Set<Jugador> jugadores = new HashSet<Jugador>();
		// jugadores.add(j1);
		// jugadores.add(new Jugador("Jug2", "Cent", betis));
		// jugadores.add(new Jugador("Jug3", "Def", betis));
		//
		// betis.setJugadores(jugadores);
		//
		// equipoDAO.guardar(betis);
		//
		// // AÑADIR JUGADOR
		// Jugador j4 = new Jugador("Jug4", "Del", betis);
		// jugDAO.guardar(j4);

		// //BORRAR EQUIPO

		// equipoDAO.borrar(obtenido);

		// BORRAR JUGADOR
		
		jugDAO.borrar(obtenido);
	}
}
