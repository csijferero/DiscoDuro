package es.altair.main;

import es.altair.bean.Direccion;
import es.altair.bean.Profesor;
import es.altair.dao.ProfesorDAO;
import es.altair.dao.ProfesorDAOImplHibernate;

public class main {

	public static void main(String[] args) {
		
		ProfesorDAO profDAO = new ProfesorDAOImplHibernate();
		
		Direccion dir = new Direccion(2500, "el barero de sevilla", 6, "sevilla", "sevilla");
		Profesor prof = new Profesor(2500, "antonio", "prof1", "prof2", dir);
		
		profDAO.guardar(prof);
		
	}

}
