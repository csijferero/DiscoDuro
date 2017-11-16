package es.altair.dao;

import java.util.HashMap;
import java.util.List;

import es.altair.bean.Receta;
import es.altair.bean.TipoReceta;
import es.altair.bean.Usuario;

public interface UsuarioDAO {

	public List<Usuario> listarTodos();

	public boolean insertar(Usuario u);

	public boolean actualizar(Usuario u);

	public Usuario obtener(int idUsuario);

	public boolean borrar(int idUsuarioB);

	public List<Usuario> mostrarUsuariosAcceso(int tipo);

	public boolean comprobarSQL1(String login, String password);

	public boolean comprobarSQL2(String login, String password);

	public List<Usuario> listarActivos();

	public List<TipoReceta> listarTiposRecetas();

	public List<Receta> listarRecetas();

	public boolean insertar(Receta r);

	public boolean borrarReceta(int idReceta);

	public boolean actualizarReceta(Receta r);

	public Receta obtenerReceta(int idReceta);

	public HashMap<Integer, Usuario> recetasDeUsuarios();

	public HashMap<Integer, Usuario> recetasDeUsuariosActivados();

}
