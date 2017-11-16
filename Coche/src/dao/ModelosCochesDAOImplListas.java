package dao;

import java.util.ArrayList;
import java.util.List;

import bean.ModeloCoche;

public class ModelosCochesDAOImplListas implements ModelosCochesDAO {
	
	private List<ModeloCoche> coches = new ArrayList<>();

	@Override
	public void insertarCoche(ModeloCoche c) {
		coches.add(c);
	}

	@Override
	public boolean actualizarCoche(ModeloCoche mcOld, ModeloCoche mcNew) {
		if (coches.contains(mcOld)) {
			coches.set(coches.indexOf(mcOld), mcNew);
			return true;
		}
		return false;
	}

	@Override
	public boolean borrarCoche(ModeloCoche c) {
		return coches.remove(c);
	}

	@Override
	public void listarCoche() {
		for (int i = 0; i < coches.size(); i++) {
			System.out.println(coches.get(i));
		}
		
	}

}
