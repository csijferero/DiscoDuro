package es.altair.hibernate.main;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.dao.GrupoDAO;
import es.altair.hibernate.dao.GrupoDAOImplHibernate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrupoDAO gDAO = new GrupoDAOImplHibernate();

		Grupo g1 = new Grupo("g1");
		Grupo g2 = new Grupo("g2");
		
		Usuario u1 = new Usuario("u1", "1234", "i1@u1.com");
		Usuario u2 = new Usuario("u2", "1234", "i2@u2.com");

		g1.getUsuarios().add(u1);
		g1.getUsuarios().add(u2);
		g2.getUsuarios().add(u1);

		u1.getGrupos().add(g1);
		u2.getGrupos().add(g1);
		u1.getGrupos().add(g2);

		gDAO.save(g1);
		gDAO.save(g2);
		
//		 Usuario obtener = gDAO.obtenerUsuario(17);
//			
//		 gDAO.borrarUsuario(obtener);

	}

}
