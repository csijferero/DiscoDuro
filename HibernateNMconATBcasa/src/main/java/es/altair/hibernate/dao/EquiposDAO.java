package es.altair.hibernate.dao;

import es.altair.hibernate.bean.EquiposInformaticos;

public interface EquiposDAO {

	public void save(EquiposInformaticos eq);

	public void borrar(EquiposInformaticos eq);

	public EquiposInformaticos obtener(int id);

}
