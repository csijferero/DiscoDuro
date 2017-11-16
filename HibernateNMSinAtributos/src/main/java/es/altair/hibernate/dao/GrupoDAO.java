package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;

public interface GrupoDAO {
	
	public void save(Grupo g);
	
	public void actu(Grupo g);

	public void borrar(Grupo g);
	
	public void borrarUsuario(Usuario u);
	
	public Usuario obtenerUsuario(int id);


	public Grupo obtener(int id);

}
