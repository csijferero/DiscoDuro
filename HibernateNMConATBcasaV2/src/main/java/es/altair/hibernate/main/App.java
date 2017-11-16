package es.altair.hibernate.main;

import java.util.Date;

import es.altair.hibernate.bean.Asistencia;
import es.altair.hibernate.bean.EquiposInformaticos;
import es.altair.hibernate.bean.Tecnicos;
import es.altair.hibernate.dao.AsistenciaDAO;
import es.altair.hibernate.dao.AsistenciaDAOImplHibernate;

public class App {

	public static void main(String[] args) {
		AsistenciaDAO asDAO = new AsistenciaDAOImplHibernate();

		Tecnicos t1 = new Tecnicos("Compañia 1", "Nombre 1", "658594584", "correo1@tec.com");

		EquiposInformaticos e1 = new EquiposInformaticos("fabricante1", "ubicacion1", new Date(), 112);

		Asistencia as = new Asistencia(e1, t1, new Date(), "motivo1");

		asDAO.save(as);

	}

}
