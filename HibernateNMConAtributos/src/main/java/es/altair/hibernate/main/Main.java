package es.altair.hibernate.main;

import java.util.Date;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.bean.UsuarioGrupo;
import es.altair.hibernate.dao.GrupoDAO;
import es.altair.hibernate.dao.GrupoDAOImplHibernate;
import es.altair.hibernate.dao.UsuarioDAO;
import es.altair.hibernate.dao.UsuarioDAOImpHibernate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrupoDAO gDAO = new GrupoDAOImplHibernate();
		UsuarioDAO uDAO = new UsuarioDAOImpHibernate();

		Usuario u1 = new Usuario("u1", "123456789", "u1@u1.com");
		Grupo g1 = new Grupo("g1");

		UsuarioGrupo usugru = new UsuarioGrupo();
		usugru.setUsuario(u1);
		usugru.setGrupo(g1);
		usugru.setActivado(true);
		usugru.setFecha_registro(new Date());

		u1.getUsuariosGrupos().add(usugru);
		g1.getUsuariosGrupos().add(usugru);

		gDAO.save(g1);
		uDAO.save(u1);

	}

}
