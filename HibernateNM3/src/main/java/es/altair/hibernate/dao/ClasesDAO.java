package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Estudiantes;

public interface ClasesDAO {
	
	public void save(Estudiantes e);
	
	public void borrar(Estudiantes g);

	public Estudiantes obtener(int id);



}
