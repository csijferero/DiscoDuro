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

	public void aņadirArtista(Artista a);

	public void aņadirCancion(Cancion c);

	public void aņadirEstilo(Estilo est);

	public Estilo comprobarAņadirEstilo(Estilo est);

	public Cancion comprobarAņadirCancion(Cancion c);

	public Artista comprobarAņadirArtista(Artista a);

	public HashMap<Artista, List<Cancion>> mostrarTodo();

}
