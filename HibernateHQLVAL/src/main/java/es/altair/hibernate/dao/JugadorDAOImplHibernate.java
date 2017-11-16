package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Equipo;
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

}
