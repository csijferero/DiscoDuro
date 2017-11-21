package es.altair.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import es.altair.hibernate.bean.Equipo;
import es.altair.hibernate.bean.Jugador;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImplHiberante;
import es.altair.hibernate.dao.JugadorDAO;
import es.altair.hibernate.dao.JugadorDAOImplHibernate;

public class App {

	public static void main(String[] args) {
		EquipoDAO eDAO = new EquipoDAOImplHiberante();
		JugadorDAO jDAO = new JugadorDAOImplHibernate();
		List<Equipo> equipos = new ArrayList<Equipo>(); 
		List<Jugador> jugadores = new ArrayList<Jugador>(); 

//		System.out.println("LISTADO DE EQUIPOS");
//		List<Equipo> equipos = eDAO.listado();
//		List<Jugador> jugadores = jDAO.listado();
//
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo);
//		}
//
//		System.out.println("LISTADO DE EQUIPOS (Nombre y Numero de Socios)");
//		equipos = eDAO.listadoNombreySocios();
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo);
//		}
//		
//		System.out.println("Obtener Un Equipo Por ID");
//		System.out.println(eDAO.obtener(1));
//		
//		System.out.println("Obtener Un Equipo Por ID");
//		System.out.println(eDAO.obtenerCS("Sevilla", 123456));
//		
//		System.out.println("LISTADO DE Jugadores (SQL)");
//		jugadores = jDAO.listado();
//		for (Jugador jugador : jugadores) {
//			System.out.println(jugador);
//		}
//		
//		System.out.println("LISTADO DE Equipos con mas de 4500 SOCIOS");
//		equipos = eDAO.listadoPorSocios(4500);
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo);
//		}
//		
//		System.out.println("LISTADO Paginado de Jugadores");
//		jDAO.mostrarJugadoresPaginacion(3);
		
		Equipo eq = new Equipo("EquipoVAL", "Sevilla", 1000000);
		eDAO.guardar(eq);
		
	}
}
