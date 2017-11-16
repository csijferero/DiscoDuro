package es.altair.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;

public class GrupoDAOImplHibernate implements GrupoDAO {

	public void save(Grupo g) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.save(g);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

	}
	
	public void actu(Grupo g) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.update(g);
			sesion.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public void borrar(Grupo g) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.delete(g);
			sesion.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public Grupo obtener(int id) {
		Grupo aux = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			aux = sesion.get(Grupo.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}
		return aux;

	}

	public void borrarUsuario(Usuario u) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			sesion.delete(u);
			sesion.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			sesion.close();
			sf.close();
		}
		
	}

	public Usuario obtenerUsuario(int id) {
		Usuario aux = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			aux = sesion.get(Usuario.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}
		return aux;
	}

}
