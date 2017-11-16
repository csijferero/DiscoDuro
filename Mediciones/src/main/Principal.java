package main;

import bean.Mediciones;
import dao.MedicionesDAO;
import dao.MedicionesDAOImpMap;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedicionesDAO medicion = new MedicionesDAOImpMap();
		
		medicion.leeryGuardarMenos("todasTemperaturas.txt", "resultado.txt");
		
		
		

	}

}
