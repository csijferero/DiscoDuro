package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Jugador;

public class JugadorDAOImplHibernate implements JugadorDAO {

	public List<Jugador> listado() {
		List<Jugador> jugadores = new ArrayList<Jugador>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			jugadores = session.createSQLQuery("SELECT * FROM jugador").addEntity(Jugador.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return jugadores;
	}

	public void mostrarJugadoresPaginacion(int i) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();

			long numJugadores = (Long) session.createQuery("SELECT count(*) FROM Jugador").uniqueResult();
			int numPaginas = (int) Math.ceil(numJugadores / i);
			Query query = (Query) session.createQuery("FROM Jugador j ORDER BY j.nombre").setMaxResults(i);
			for (int j = 0; j < i; j++) {
				System.out.println("-- Página " + (j + 1) + " --");
				query.setFirstResult(j * i);
				List<Jugador> jugadores = query.list();
				for (Jugador jugador : jugadores) {
					System.out.println(jugador);
				}
			}

			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
	}

}
