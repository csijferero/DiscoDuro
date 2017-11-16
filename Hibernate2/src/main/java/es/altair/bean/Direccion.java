package es.altair.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

	@Id
	private int id;
	private String calle;
	private int numero;
	private String poblacion;
	private String provincia;
	@OneToOne(cascade = CascadeType.ALL) //Relacion 1:1 entre las dos tablas
	@PrimaryKeyJoinColumn //Relacion mediante la clave primaria
	private Profesor profesor;
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(int id, String calle, int numero, String poblacion, String provincia) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion
				+ ", provincia=" + provincia + "]";
	}

}
