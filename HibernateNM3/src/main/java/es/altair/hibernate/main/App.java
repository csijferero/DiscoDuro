package es.altair.hibernate.main;

import es.altair.hibernate.bean.Clases;
import es.altair.hibernate.bean.Estudiantes;
import es.altair.hibernate.dao.ClasesDAO;
import es.altair.hibernate.dao.ClasesDAOImplHibernate;

public class App {

	public static void main(String[] args) {
		ClasesDAO claDAO = new ClasesDAOImplHibernate();
		
		Clases c1 = new Clases("titClas1", "prueba 1", 124);
		Clases c2 = new Clases("titClas2", "prueba 2", 11);
		
		Estudiantes est = new Estudiantes("est1Nom", "est1Ape", 20);
		Estudiantes est2 = new Estudiantes("est2Nom", "est2Ape", 20);
		
		c1.getEstudiantes().add(est);
		c2.getEstudiantes().add(est);
		c1.getEstudiantes().add(est2);
		
		est.getClases().add(c1);
		est.getClases().add(c2);
		est2.getClases().add(c1);
		
		claDAO.save(est);
		claDAO.save(est2);
		
//		 Estudiantes obtener = claDAO.obtener(1);
//			
//		 claDAO.borrar(obtener);
	}

}
