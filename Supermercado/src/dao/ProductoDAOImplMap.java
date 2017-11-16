package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bean.Producto;

public class ProductoDAOImplMap implements ProductoDAO {

	private Map<Integer, Producto> productos = new HashMap<>();

	@Override
	public void anadiranadir(Producto p) {
		productos.put(p.getCodigo(), p);
	}

	@Override
	public Boolean borar(Integer codigo) {
		if (productos.containsKey(codigo)) {
			productos.remove(codigo);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean actualizar(Producto p) {
		if (productos.containsKey(p.getCodigo())) {
			productos.replace(p.getCodigo(), p);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void listar() {
		for (Producto p : productos.values()) {
			System.out.println(p);
		}

		// 2º Forma
		Set<Integer> claves = productos.keySet();
		Iterator<Integer> iterator = claves.iterator();
		while (iterator.hasNext()) {
			Integer cla = (Integer) iterator.next();
			System.out.println(productos.get(cla));
		}

	}

	@Override
	public void borrarTodos() {
		productos.clear();
	}

	@Override
	public void generarFichero(String nombreFichero) {
		File fichero = new File(nombreFichero);
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);

			for (Producto p : productos.values()) {
				bw.write(p.getCodigo() + ";" + p.getNombre() + ";" + p.getPrecio());
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

	@Override
	public void recuperarFichero(String nombreFichero) {
		File fichero = new File(nombreFichero);
		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				String linea;
				while ((linea=br.readLine())!=null) {
					String [] partes = linea.split(";");
					Producto p = new Producto(Integer.parseInt(partes[0]), 
							Double.parseDouble(partes[2]), partes[1]);
					anadiranadir(p);					
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
			}
		} else {
			System.out.println("Error en el fichero");
		}
	}

}
