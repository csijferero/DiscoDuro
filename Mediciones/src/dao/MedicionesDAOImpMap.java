package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import bean.Mediciones;

public class MedicionesDAOImpMap implements MedicionesDAO {
	
	private HashMap<String, Mediciones> temperaturas = new HashMap<>();

	@Override
	public void leeryGuardarMenos(String fichIn, String fichOut) {
		
		File ficheroIn = new File(fichIn);
		if (ficheroIn.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(ficheroIn);
				br = new BufferedReader(fr);
				
				String linea="";
				while ((linea=br.readLine())!=null) {
					String [] partes = linea.split(" ");
					Mediciones m = new Mediciones(partes[0], crearTemperaturas(partes));
					temperaturas.put(partes[0], m);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				File ficheroOut = new File(fichOut);
				if(!ficheroOut.exists()) {
					try {
						ficheroOut.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try {
					fw = new FileWriter(ficheroOut);
					bw = new BufferedWriter(fw);
					
					for (Mediciones m: temperaturas.values()) {
						Integer menor = calcularMenorTemperatura(m.getTemperaturas());
						bw.write(m.getNombre() + " " + menor);
						bw.newLine();
						bw.flush();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						bw.close();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
	}

	private Integer calcularMenorTemperatura(ArrayList<Integer> temperaturas2) {
		Integer menor = temperaturas2.get(0);
		
		for (Integer temp : temperaturas2) {
			if(temp < menor)
				menor = temp;
		}
		
		return menor;
	}

	private ArrayList<Integer> crearTemperaturas(String[] partes) {
		ArrayList<Integer> tabla = new ArrayList<>();
		
		for (int i = 1; i < partes.length; i++) {
			tabla.add(Integer.parseInt(partes[i]));
		}
		
		return tabla;
	}

	

}
