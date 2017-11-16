package es.mitrabajo.dao;

import java.util.HashMap;
import java.util.List;

import es.mitrabajo.bean.Artista;
import es.mitrabajo.bean.Cancion;
import es.mitrabajo.bean.Estilo;

public interface ArtistaDAO {

	public List<Artista> listarTodosArtistasEstilo(int idEstilo);

	public List<Estilo> listarTodosEstilos();

	public List<Artista> listarTodosArtistas();

	public List<Cancion> listarTodosCancionesArtistas(int idArtista);

	public Artista obtenerArtista(int idUsuario);

	public void actualizar(Artista a);

	public boolean borrar(int idArtista);

	public List<Artista> listarTodosPaises();

	public List<Cancion> obtenerCancion(String paisArtista);

	public void actualizarDuracion(List<Cancion> c);

	public void a�adirArtista(Artista a);

	public void a�adirCancion(Cancion c);

	public void a�adirEstilo(Estilo est);

	public Estilo comprobarA�adirEstilo(Estilo est);

	public Cancion comprobarA�adirCancion(Cancion c);

	public Artista comprobarA�adirArtista(Artista a);

	public HashMap<Artista, List<Cancion>> mostrarTodo();

}
