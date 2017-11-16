package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Tecnicos;

public interface TecnicosDAO {

	public void save(Tecnicos tec);

	public void borrar(Tecnicos tec);

	public Tecnicos obtener(int id);

}
