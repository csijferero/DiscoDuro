package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clases")
public class Clases implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclases;
	private String titulo;
	private String descripcion;
	private int num_horas;


	@ManyToMany(mappedBy="clases")
	private Set<Estudiantes> estudiantes = new HashSet<Estudiantes>();

	public Clases() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clases(String titulo, String descripcion, int num_horas) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.num_horas = num_horas;
	}

	public int getIdclases() {
		return idclases;
	}

	public void setIdclases(int idclases) {
		this.idclases = idclases;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(int num_horas) {
		this.num_horas = num_horas;
	}

	public Set<Estudiantes> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiantes> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
