package bean;

import java.util.ArrayList;

public class Mediciones {

	private String nombre;
	private ArrayList<Integer> temperaturas = new ArrayList<>();
	
	public Mediciones(String nombre, ArrayList<Integer> temperaturas) {
		super();
		this.nombre = nombre;
		this.temperaturas = temperaturas;
	}
	public Mediciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Integer> getTemperaturas() {
		return temperaturas;
	}
	public void setTemperaturas(ArrayList<Integer> temperaturas) {
		this.temperaturas = temperaturas;
	}
	@Override
	public String toString() {
		return "Mediciones [nombre=" + nombre + ", temperaturas=" + temperaturas + "]";
	}
	
	
	
	
}
