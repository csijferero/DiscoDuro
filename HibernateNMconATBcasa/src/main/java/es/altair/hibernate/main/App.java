package es.altair.hibernate.main;

import java.util.Date;

import es.altair.hibernate.bean.Asistencia;
import es.altair.hibernate.bean.EquiposInformaticos;
import es.altair.hibernate.bean.Tecnicos;
import es.altair.hibernate.dao.EquiposDAO;
import es.altair.hibernate.dao.EquiposDAOImplHibernate;
import es.altair.hibernate.dao.TecnicosDAO;
import es.altair.hibernate.dao.TecnicosDAOImplHibernate;

public class App {

	public static void main(String[] args) {
		EquiposDAO eqDAO = new EquiposDAOImplHibernate();
		TecnicosDAO tecDAO = new TecnicosDAOImplHibernate();

//		 Tecnicos t1 = new Tecnicos("CompañiaTecnico1", "nombreTecnico1", "698598532",
//		 "tecnico1@tec.com");
//		 Tecnicos t2 = new Tecnicos("CompañiaTecnico2", "nombreTecnico2", "698598532",
//		 "tecnico2@tec.com");
//		 Tecnicos t3 = new Tecnicos("CompañiaTecnico3", "nombreTecnico3", "698598532",
//				 "tecnico3@tec.com");
//		 
//		 EquiposInformaticos e1 = new EquiposInformaticos("fabricante1", "ubicacion1",
//		 new Date(), 112);
//		 EquiposInformaticos e2 = new EquiposInformaticos("fabricante2", "ubicacion2",
//		 new Date(), 112);
//		
//		 Asistencia asistencia = new Asistencia();
//		 asistencia.setEquiposInformaticos(e1);
//		 asistencia.setTecnicos(t1);
//		 asistencia.setFecha_hora(new Date());
//		 asistencia.setMotivo("motivo1");
//		
//		 Asistencia asistencia2 = new Asistencia();
//		 asistencia2.setEquiposInformaticos(e2);
//		 asistencia2.setTecnicos(t1);
//		 asistencia2.setFecha_hora(new Date());
//		 asistencia2.setMotivo("motivo2");
//		 
//		 Asistencia asistencia3 = new Asistencia();
//		 asistencia3.setEquiposInformaticos(e2);
//		 asistencia3.setTecnicos(t3);
//		 asistencia3.setFecha_hora(new Date());
//		 asistencia3.setMotivo("motivo3");
//		
//		 t1.getAsistencia().add(asistencia);
//		 t1.getAsistencia().add(asistencia2);
//		 t1.getAsistencia().add(asistencia3);
//		 
//		 t2.getAsistencia().add(asistencia);
//		 t2.getAsistencia().add(asistencia2);
//		 t2.getAsistencia().add(asistencia3);
//		 
//		 t3.getAsistencia().add(asistencia);
//		 t3.getAsistencia().add(asistencia2);
//		 t3.getAsistencia().add(asistencia3);
//		 
//		 e1.getAsistencia().add(asistencia);
//		 e1.getAsistencia().add(asistencia2);
//		 e1.getAsistencia().add(asistencia3);
//		 
//		 e2.getAsistencia().add(asistencia);
//		 e2.getAsistencia().add(asistencia2);
//		 e2.getAsistencia().add(asistencia3);
//
//		 eqDAO.save(e1);
//		 tecDAO.save(t1);
//		 eqDAO.save(e2);
//		 tecDAO.save(t2);
//		 tecDAO.save(t3);

		EquiposInformaticos obtener = eqDAO.obtener(13);

		eqDAO.borrar(obtener);

	}

}
