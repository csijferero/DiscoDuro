package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import es.altair.hibernate.bean.Equipo;

public class EquipoDAOImplHiberante implements EquipoDAO {

	public List<Equipo> listado() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			equipos = session.createQuery("FROM Equipo").list();
			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return equipos;
	}

	public List<Equipo> listadoNombreySocios() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			equipos = session.createQuery("SELECT new Equipo(e.nombre, e.numSocios) FROM Equipo e").list();
			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return equipos;
	}

	public Equipo obtener(int i) {
		Equipo eq = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();

			// eq = (Equipo) session.createQuery("FROM Equipo WHERE idEquipo=" +
			// i).uniqueResult();

			eq = (Equipo) session.createQuery("FROM Equipo WHERE idEquipo=:id").setParameter("id", i).uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return eq;
	}

	public Equipo obtenerCS(String ciudad, int numSocio) {
		Equipo eq = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();

			// eq = (Equipo) session.createQuery("FROM Equipo WHERE idEquipo=" +
			// i).uniqueResult();

			eq = (Equipo) session.createQuery("FROM Equipo WHERE ciudad=:ci AND numSocios=:ns")
					.setParameter("ci", ciudad).setParameter("ns", numSocio).uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return eq;
	}

	public List<Equipo> listadoPorSocios(int num) {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			equipos = session.createCriteria(Equipo.class).add(Restrictions.gt("numSocios", num)).list();
			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sf.close();
		}
		return equipos;
	}

	public void guardar(Equipo eq) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			session.save(eq);
			session.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			session.getTransaction().rollback();
			System.out.println("--- Errores ---");
			for (ConstraintViolation cv : e.getConstraintViolations()) {
				System.out.println("Campo: " + cv.getPropertyPath());
				System.out.println("Mensaje: " + cv.getMessage());
			}
		} finally {
			session.close();
			sf.close();
		}

	}

}
