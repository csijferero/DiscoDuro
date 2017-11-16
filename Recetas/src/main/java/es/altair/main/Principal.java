package es.altair.main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import es.altair.bean.Receta;
import es.altair.bean.TipoReceta;
import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplJDBC;

public class Principal {

	private static UsuarioDAO uDAO = new UsuarioDAOImplJDBC();

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// // INSERTAR
		//
		// Usuario usu = new Usuario("Alumno Usu", "Apellidos USU", "alumusu",
		// "alumusu123", "alumusu@gmail.com", 1, 1);
		//
		// if (uDAO.insertar(usu))
		// System.out.println("Usuario insertado");
		// else
		// System.out.println("No se ha podido insertar al usuario");
		//
		// // Listar obbtener y actualizar
		// listadoUsuarios();

		// ACTUALIZAR
		// System.out.println("Seleccione Usuario para actualizar (ID): ");
		// int idUsuario = sc.nextInt();
		// Usuario usuAct = uDAO.obtener(idUsuario);
		// if (usuAct != null) {
		// usuAct.setNombre(usuAct.getNombre() + "_EXT");
		// if (uDAO.actualizar(usuAct))
		// System.out.println("Usuario actualizado");
		// else
		// System.out.println("No se ha podido actualizar al usuario");
		// } else
		// System.out.println("Error al obtener el usuario a actualizar");
		//
		// //BORRADO
		// listadoUsuarios();
		// System.out.println("Seleccione Usuario para Borrar (ID): ");
		// int idUsuarioB = sc.nextInt();
		// if (uDAO.borrar(idUsuarioB))
		// System.out.println("Usuario Borrado");
		// else
		// System.out.println("No se ha podido borrar el usuario");
		//
		// //MOSTRAR USUARIOS TIPO 1
		// List<Usuario> usuarios = uDAO.mostrarUsuariosAcceso(1);
		// for (Usuario usuario : usuarios) {
		// System.out.println(usuario);
		// }
		//
		// System.out.println("Login: ");
		// String login = sc.nextLine();
		// System.out.println("Password: ");
		// String password = sc.nextLine();
		//
		// if(uDAO.comprobarSQL1(login, password))
		// System.out.println("Login Correcto");
		// else
		// System.out.println("Login Incorrecto");
		//
		// if(uDAO.comprobarSQL2(login, password))
		// System.out.println("Login Correcto");
		// else
		// System.out.println("Login Incorrecto");
		// --------------------------------------------------//********************************************************************//

		// LISTAR USUARIOS ACTIVOS
		// List<Usuario> usuarios = uDAO.listarActivos();
		// for (Usuario usuario : usuarios) {
		// System.out.println(usuario);
		// }

		// LISTAR TODOS LOS TIPOS DE RECETAS
		// listarTiposRecetas();

		// LISTAR TODAS LAS RECETAS
		// listarRecetas();

		// INSERTAR RECETA
		// Receta receta = new Receta("Serrano", 2, "Comida Sevillana", 1);
		//
		// if (uDAO.insertar(receta))
		// System.out.println("Receta insertada");
		// else
		// System.out.println("No se ha podido insertar la Receta");

		// BORRAR RECETA
		// listarRecetas();
		// System.out.println("Seleccione Receta para Borrar (ID): ");
		// int idReceta = sc.nextInt();
		// if (uDAO.borrarReceta(idReceta))
		// System.out.println("Receta Borrada");
		// else
		// System.out.println("No se ha podido borrar la receta");

		// ACTUALIZAR RECETA
		// System.out.println("Seleccione la receta para actualizar (ID): ");
		// int idReceta = sc.nextInt();
		// Receta recAct = uDAO.obtenerReceta(idReceta);
		// if (recAct != null) {
		// recAct.setNombre(recAct.getNombre() + "_EXT");
		// if (uDAO.actualizarReceta(recAct))
		// System.out.println("Usuario actualizado");
		// else
		// System.out.println("No se ha podido actualizar al usuario");
		// } else
		// System.out.println("Error al obtener el usuario a actualizar");

		// LISTAR RECETAS DE COMIDA NORMAL DE USUARIOS ACTIVADOS
		HashMap<Integer, Usuario> recetasUsuarios = uDAO.recetasDeUsuariosActivados();
		List<Receta> recetas = uDAO.listarRecetas();
		for (Usuario ru : recetasUsuarios.values()) {			
			for (Receta r : recetas) {
				if(ru.getIdUsuario() == r.getIdUsuario() && r.getIdTipoReceta()==5)
					System.out.println(r);
			}
			System.out.println();
		}

		// MOSTRAR TODAS LAS RECETAS DE TODOS LOS USUARIOS
//		HashMap<Integer, Usuario> recetasUsuarios = uDAO.recetasDeUsuarios();
//		List<Receta> recetas = uDAO.listarRecetas();
//		for (Usuario ru : recetasUsuarios.values()) {
//			System.out.println(ru);
//			for (Receta r : recetas) {
//				if (r.getIdUsuario() == ru.getIdUsuario())
//					System.out.println(r);
//			}
//			System.out.println();
//		}
		
		
		sc.close();
	}

	private static void listarRecetas() {
		List<Receta> recetas = uDAO.listarRecetas();
		for (Receta r : recetas) {
			System.out.println(r);
		}
	}

	private static void listarTiposRecetas() {
		List<TipoReceta> tipoRecetas = uDAO.listarTiposRecetas();
		for (TipoReceta tr : tipoRecetas) {
			System.out.println(tr);
		}
	}

	private static void listadoUsuarios() {
		List<Usuario> usuarios = uDAO.listarTodos();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

}
