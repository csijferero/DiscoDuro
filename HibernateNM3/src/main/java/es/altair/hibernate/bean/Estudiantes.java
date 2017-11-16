package es.altair.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiantes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idestudiantes;
	private String nombre;
	private String apellidos;
	private int edad;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matriculas", joinColumns = @JoinColumn(name = "idestudiantes"), inverseJoinColumns = @JoinColumn(name = "idclases"))
	private Set<Clases> clases = new  HashSet<Clases>();
	
	
	
	public Estudiantes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estudiantes(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	public int getIdestudiantes() {
		return idestudiantes;
	}
	public void setIdestudiantes(int idestudiantes) {
		this.idestudiantes = idestudiantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Set<Clases> getClases() {
		return clases;
	}
	public void setClases(Set<Clases> clases) {
		this.clases = clases;
	}
	
	

}
