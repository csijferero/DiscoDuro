package main;

import bean.ModeloCoche;
import dao.ModelosCochesDAO;
import dao.ModelosCochesDAOImplListas;

public class Principal {

	public static void main(String[] args) {
		
		ModelosCochesDAO modelosCochesDAO = new ModelosCochesDAOImplListas();
		
		ModeloCoche mod1 = new ModeloCoche(1998, 160, 1.500F, "Seat", "Ibiza");
		ModeloCoche mod2 = new ModeloCoche(2010, 180, 5.000F, "Toyota", "Prius");
		
		modelosCochesDAO.insertarCoche(mod1);
		modelosCochesDAO.insertarCoche(mod2);
		
		
		modelosCochesDAO.listarCoche();
	}

}
