package es.mitrabajo.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import es.mitrabajo.bean.Artista;
import es.mitrabajo.bean.Cancion;
import es.mitrabajo.bean.Estilo;
import es.mitrabajo.dao.ArtistaDAO;
import es.mitrabajo.dao.ArtistaDAOImplJDBC;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	private static ArtistaDAO aDAO = new ArtistaDAOImplJDBC();

	private static int contador = 0;

	private static int auxID = 0;

	public static void main(String[] args) {
		int aux;

		do {
			System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                 MENU                                       ║");
			System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
			System.out.println("║        1. Añadir Artista                                                   ║");
			System.out.println("║        2. Añadir Cancion                                                   ║");
			System.out.println("║        3. Añadir Estilo                                                    ║");
			System.out.println("║        4. Listar Artistas de un Estilo                                     ║");
			System.out.println("║        5. Listar Canciones de un Artista                                   ║");
			System.out.println("║        6. Actualizar edad de un Artista                                    ║");
			System.out.println("║        7. Añadir un minuto a las canciones de los artistas de un pais      ║");
			System.out.println("║        8. Borrar todas las canciones de un artista                         ║");
			System.out.println("║        9. Mostrar todo (artista y sus canciones)                           ║");
			System.out.println("║        0. Salir                                                            ║");
			System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
			aux = capturaEntero("Elija una opcion", 0, 9);
			System.out.println();
			sc.nextLine();
			switch (aux) {
			case 1:
				if (aDAO.listarTodosEstilos().size() != 0) {
					System.out.print("Escriba el nombre del artista: ");
					String nombreNuevoArtista = capturaCadena();
					System.out.print("Escriba el apellido del artista: ");
					String apellidoNuevoArtista = capturaCadena();
					System.out.print("Escriba el pais del artista: ");
					String paisNuevoArtista = capturaCadena();
					int edadNuevoArtista = capturaEntero("Escriba la edad del artista", 1, 99);
					int estiloNuevoArtista = seleccionaEstilo();

					Artista a = new Artista(estiloNuevoArtista, nombreNuevoArtista, apellidoNuevoArtista,
							edadNuevoArtista, paisNuevoArtista);

					if (aDAO.comprobarAñadirArtista(a) == null) {
						aDAO.añadirArtista(a);
					} else {
						System.out.println("El Artista deseado ya existe");
					}
				} else
					System.out.println("Necesitas que existan Estilos para añadir un Artista");

				break;
			case 2:
				if (aDAO.listarTodosArtistas().size() != 0) {
					System.out.print("Escriba el nombre de la cancion: ");
					String nombreNuevaCancion = capturaCadena();
					int duracionNuevaCancion = capturaEntero("Escriba la duracion de la cancion", 1, 300);
					int idArtistaNuevaCancion = seleccionaArtista();

					Cancion c = new Cancion(idArtistaNuevaCancion, nombreNuevaCancion, duracionNuevaCancion);

					if (aDAO.comprobarAñadirCancion(c) == null) {
						aDAO.añadirCancion(c);
					} else {
						System.out.println("La Canción deseada ya existe");
					}
				} else
					System.out.println("Necesitas que existan Artistas para añadir una Canción");

				break;
			case 3:
				System.out.print("Escriba el nombre del estilo: ");
				String nombreNuevoEstilo = capturaCadena();

				Estilo est = new Estilo(nombreNuevoEstilo);

				if (aDAO.comprobarAñadirEstilo(est) == null) {

					aDAO.añadirEstilo(est);
				} else {
					System.out.println("El Estilo deseado ya existe");
				}

				break;
			case 4:
				int idEstilo = seleccionaEstilo();
				if (idEstilo != -1) {

					List<Artista> artistas = aDAO.listarTodosArtistasEstilo(idEstilo);
					if (artistas.size() > 0) {
						for (Artista artista : artistas) {
							System.out.println(artista);
						}
					} else
						System.out.println("No se han encontrado Artistas para este Estilo");
				} else
					System.out.println("No existen Estilos");
				break;
			case 5:
				int idArtista = seleccionaArtista();
				if (idArtista != -1) {

					List<Cancion> canciones = aDAO.listarTodosCancionesArtistas(idArtista);
					if (canciones.size() > 0) {
						for (Cancion cancion : canciones) {
							System.out.println(cancion);
						}
					} else
						System.out.println("No se han encontrado Canciones para este Artista");
				} else
					System.out.println("No existen Artistas");
				break;
			case 6:
				int idArtista2 = seleccionaArtista();
				if (idArtista2 != -1) {

					Artista artistaAct = aDAO.obtenerArtista(idArtista2);
					artistaAct.setEdadArtista(capturaEntero("Introduzca la nueva edad", 1, 99));
					aDAO.actualizar(artistaAct);
				} else
					System.out.println("No existen Artistas");
				break;
			case 7:
				String paisArtista = seleccionPais();
				if (paisArtista != null) {

					List<Cancion> cancionAct = aDAO.obtenerCancion(paisArtista);
					if (cancionAct.size() > 0) {
						for (int i = 0; i < cancionAct.size(); i++) {
							cancionAct.get(i).setDuracionCancion(cancionAct.get(i).getDuracionCancion() + 60);
						}
						aDAO.actualizarDuracion(cancionAct);
					} else
						System.out.print("No existen Canciones de ningun Artista de este Pais");
				} else
					System.out.println("No existen Artistas");
				break;
			case 8:
				int idArtistaB = seleccionaArtista();
				if (idArtistaB != -1) {
					if (aDAO.borrar(idArtistaB))
						System.out.println("OK");
					else
						System.out.println("No existen Canciones para este Artista");

				} else
					System.out.println("No existen Artistas");

				break;
			case 9:

				HashMap<Artista, List<Cancion>> mapa = aDAO.mostrarTodo();
				if (mapa.size() != 0) {

					Iterator<Artista> it = mapa.keySet().iterator();
					while (it.hasNext()) {
						Artista key = it.next();
						if (mapa.get(key).size() == 0)
							System.out.println(key + "\n" + "SIN CANCIONES" + "\n");
						else
							System.out.println(key + "\n" + mapa.get(key) + "\n");
					}
				} else
					System.out.println("No se ha encontrado ningun Artista ni Canción");

				break;

			default:
				break;
			}
			System.out.println("\n");

		} while (aux != 0);

		sc.close();
	}

	private static int seleccionaEstilo() {
		contador = 0;
		List<Estilo> estilos = aDAO.listarTodosEstilos();
		if (estilos.size() > 0) {
			for (Estilo estilo : estilos) {
				contador++;
				System.out.println(contador + ") " + estilo);
			}

			auxID = capturaEntero("Seleccione el estilo deseado", 1, aDAO.listarTodosEstilos().size());

			return (estilos.get(auxID - 1).getIdEstilo());
		} else
			return -1;
	}

	private static int seleccionaArtista() {
		contador = 0;
		List<Artista> artistas = aDAO.listarTodosArtistas();
		if (artistas.size() > 0) {
			for (Artista artista : artistas) {
				contador++;
				System.out.println(contador + ") " + artista);
			}

			auxID = capturaEntero("Seleccione el artista deseado", 1, aDAO.listarTodosArtistas().size());

			return (artistas.get(auxID - 1).getIdArtista());
		} else
			return -1;
	}

	private static String seleccionPais() {
		contador = 0;
		List<Artista> artistas = aDAO.listarTodosPaises();
		if (artistas.size() > 0) {
			for (Artista artista : artistas) {
				contador++;
				System.out.println(contador + ") " + artista.getPaisArtista());
			}

			auxID = capturaEntero("Seleccione el pais de los cantantes a los que añadir un minuto a sus canciones", 1,
					aDAO.listarTodosPaises().size());

			return (artistas.get(auxID - 1).getPaisArtista());
		} else
			return null;
	}

	private static int capturaEntero(String enunciado, int min, int max) {
		String aux = "";
		int res = 0;

		do {
			System.out.println();
			System.out.print(enunciado + " " + "[" + min + "-" + max + "] ");
			aux = sc.next();
			try {
				res = Integer.parseUnsignedInt(aux);
			} catch (NumberFormatException e) {
				res = -1;
			}

		} while (res < min || res > max);

		return res;
	}
	
	private static String capturaCadena() {
		String cadena = null;
		do {
			cadena = sc.nextLine();
		} while (cadena.isEmpty());
		return cadena;
	}
}