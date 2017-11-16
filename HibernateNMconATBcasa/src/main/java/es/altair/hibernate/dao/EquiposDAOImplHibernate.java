package es.altair.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.EquiposInformaticos;

public class EquiposDAOImplHibernate implements EquiposDAO {

	public void save(EquiposInformaticos eq) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.save(eq);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
	}

	public void borrar(EquiposInformaticos eq) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.delete(eq);
			sesion.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public EquiposInformaticos obtener(int id) {
		EquiposInformaticos aux = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			aux = sesion.get(EquiposInformaticos.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}
		return aux;
	}

}
