package dao;

import java.util.HashSet;
import java.util.Set;

import bin.Diccionario;

public class DiccionarioDAOImplConj implements DiccionarioDAO {

	private Set<Diccionario> Diccionarios = new HashSet<>();
	
	@Override
	public void anadir(Diccionario p) {
		Diccionarios.add(p);
	}

	@Override
	public Boolean borrar(Diccionario p) {
		return Diccionarios.remove(p);
	}

	@Override
	public Boolean buscar(Diccionario p) {
		return Diccionarios.contains(p);
	}

	@Override
	public String obtenerDefinicion(String pal) {
		for (Diccionario Diccionario : Diccionarios) {
			if (Diccionario.getPalabra().equalsIgnoreCase(pal)) {
				return Diccionario.getDefinicion();
			}
		}
		return "";
	}

	@Override
	public void listar() {
		for (Diccionario Diccionario : Diccionarios) {
			System.out.println(Diccionario.getPalabra() + ": " + Diccionario.getDefinicion());
		}
	}

}