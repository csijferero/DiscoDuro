package es.mitrabajo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.mitrabajo.bean.Artista;
import es.mitrabajo.bean.Cancion;
import es.mitrabajo.bean.Estilo;

public class ArtistaDAOImplJDBC implements ArtistaDAO {

	public List<Artista> listarTodosArtistasEstilo(int idEstilo) {
		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE idEstilo = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idEstilo);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("idArtista"), resultado.getInt("idEstilo"),
						resultado.getString("nombreArtista"), resultado.getString("apellidosArtista"),
						resultado.getInt("edadArtista"), resultado.getString("paisArtista"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}

	public List<Estilo> listarTodosEstilos() {

		List<Estilo> estilos = new ArrayList<Estilo>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ESTILO";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Estilo e = new Estilo(resultado.getInt("idEstilo"), resultado.getString("nombreEstilo"));
				estilos.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return estilos;
	}

	public List<Artista> listarTodosArtistas() {

		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("idArtista"), resultado.getInt("idEstilo"),
						resultado.getString("nombreArtista"), resultado.getString("apellidosArtista"),
						resultado.getInt("edadArtista"), resultado.getString("paisArtista"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}

	public List<Cancion> listarTodosCancionesArtistas(int idArtista) {
		List<Cancion> canciones = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCION WHERE idArtista = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Cancion c = new Cancion(resultado.getInt("idCancion"), resultado.getInt("idArtista"),
						resultado.getString("nombreCancion"), resultado.getInt("duracionCancion"));
				canciones.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return canciones;
	}

	public void actualizar(Artista a) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE ARTISTA SET idEstilo = ?, nombreArtista = ?, "
				+ "apellidosArtista = ?, edadArtista = ?, paisArtista = ?" + "WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, a.getIdEstilo());
			sentencia.setString(2, a.getNombreArtista());
			sentencia.setString(3, a.getApellidoArtista());
			sentencia.setInt(4, a.getEdadArtista());
			sentencia.setString(5, a.getPaisArtista());
			sentencia.setInt(6, a.getIdArtista());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

	}

	public Artista obtenerArtista(int idUsuario) {
		Artista a = null;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idUsuario);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				a = new Artista(resultado.getInt("idArtista"), resultado.getInt("idEstilo"),
						resultado.getString("nombreArtista"), resultado.getString("apellidosArtista"),
						resultado.getInt("edadArtista"), resultado.getString("paisArtista"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return a;
	}

	public boolean borrar(int idArtista) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "DELETE FROM CANCION WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public List<Artista> listarTodosPaises() {
		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT DISTINCT paisArtista FROM ARTISTA";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Artista a = new Artista(resultado.getString("paisArtista"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}

	public void actualizarDuracion(List<Cancion> c) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE CANCION SET idArtista = ?, nombreCancion = ?, " + "duracionCancion = ? "
				+ "WHERE idCancion = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);

			for (int i = 0; i < c.size(); i++) {
				sentencia.setInt(1, c.get(i).getIdArtista());
				sentencia.setString(2, c.get(i).getNombreCancion());
				sentencia.setInt(3, c.get(i).getDuracionCancion());
				sentencia.setInt(4, c.get(i).getIdCancion());
				num_filas = sentencia.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

	}

	public List<Cancion> obtenerCancion(String paisArtista) {
		List<Cancion> canciones = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCION WHERE idArtista IN (SELECT idArtista FROM ARTISTA WHERE paisArtista = ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, paisArtista);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Cancion c = new Cancion(resultado.getInt("idCancion"), resultado.getInt("idArtista"),
						resultado.getString("nombreCancion"), resultado.getInt("duracionCancion"));
				canciones.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return canciones;
	}

	public void añadirArtista(Artista a) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO ARTISTA VALUES(null, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, a.getIdEstilo());
			sentencia.setString(2, a.getNombreArtista());
			sentencia.setString(3, a.getApellidoArtista());
			sentencia.setInt(4, a.getEdadArtista());
			sentencia.setString(5, a.getPaisArtista());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();
	}

	public void añadirCancion(Cancion c) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO CANCION VALUES(null, ?, ?, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, c.getIdArtista());
			sentencia.setString(2, c.getNombreCancion());
			sentencia.setInt(3, c.getDuracionCancion());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();
	}

	public void añadirEstilo(Estilo est) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO ESTILO VALUES(null, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, est.getNombreEstilo());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();
	}

	public Estilo comprobarAñadirEstilo(Estilo est) {

		ConexionDAO.abrirConexion();

		Estilo estilo = null;

		String query = "SELECT * FROM ESTILO WHERE nombreEstilo = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, est.getNombreEstilo());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				estilo = new Estilo(resultado.getInt("idEstilo"), resultado.getString("nombreEstilo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return estilo;
	}

	public Cancion comprobarAñadirCancion(Cancion c) {

		ConexionDAO.abrirConexion();

		Cancion cancion = null;

		String query = "SELECT * FROM CANCION WHERE (idArtista = ? AND nombreCancion = ? AND duracionCancion = ? )";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, c.getIdArtista());
			sentencia.setString(2, c.getNombreCancion());
			sentencia.setInt(3, c.getDuracionCancion());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				cancion = new Cancion(resultado.getInt("idArtista"), resultado.getString("nombreCancion"),
						resultado.getInt("duracionCancion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return cancion;
	}

	public Artista comprobarAñadirArtista(Artista a) {

		ConexionDAO.abrirConexion();

		Artista artista = null;

		String query = "SELECT * FROM ARTISTA WHERE (idEstilo = ? AND nombreArtista = ? AND apellidosArtista = ? AND edadArtista = ? AND paisArtista = ? )";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, a.getIdEstilo());
			sentencia.setString(2, a.getNombreArtista());
			sentencia.setString(3, a.getApellidoArtista());
			sentencia.setInt(4, a.getEdadArtista());
			sentencia.setString(5, a.getPaisArtista());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				artista = new Artista(resultado.getInt("idEstilo"), resultado.getString("nombreArtista"),
						resultado.getString("apellidosArtista"), resultado.getInt("edadArtista"),
						resultado.getString("paisArtista"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artista;
	}

	public HashMap<Artista, List<Cancion>> mostrarTodo() {
		HashMap<Artista, List<Cancion>> mapa = new HashMap<Artista, List<Cancion>>();
		List<Artista> auxArtista = new ArrayList<Artista>();
		List<Cancion> auxCancion = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("idArtista"), resultado.getInt("idEstilo"),
						resultado.getString("nombreArtista"), resultado.getString("apellidosArtista"),
						resultado.getInt("edadArtista"), resultado.getString("paisArtista"));
				auxArtista.add(a);
			}

			query = "SELECT * FROM CANCION";
			ResultSet resultado2 = sentencia.executeQuery(query);
			while (resultado2.next()) {

				Cancion c = new Cancion(resultado2.getInt("idCancion"), resultado2.getInt("idArtista"),
						resultado2.getString("nombreCancion"), resultado2.getInt("duracionCancion"));
				auxCancion.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		for (int i = 0; i < auxArtista.size(); i++) {
			List<Cancion> listaCanciones = new ArrayList<Cancion>();
			for (int j = 0; j < auxCancion.size(); j++) {
				if (auxCancion.get(j).getIdArtista() == auxArtista.get(i).getIdArtista())
					listaCanciones.add(auxCancion.get(j));
			}
			mapa.put(auxArtista.get(i), listaCanciones);
		}

		return mapa;

	}

}
