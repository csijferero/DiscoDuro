package es.altair.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="correoElectronico")
public class CorreoElectronico implements Serializable {

	@Id
	private int idCorreo;
	private String DireccionCorreo;

	@ManyToOne
	@JoinColumn(name="idProfesor")
	private Profesor profesor;

	public CorreoElectronico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CorreoElectronico(int idCorreo, String direccionCorreo, Profesor profesor) {
		super();
		this.idCorreo = idCorreo;
		DireccionCorreo = direccionCorreo;
		this.profesor = profesor;
	}

	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getDireccionCorreo() {
		return DireccionCorreo;
	}

	public void setDireccionCorreo(String direccionCorreo) {
		DireccionCorreo = direccionCorreo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}
