package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tecnicos")
public class Tecnicos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtecnicos;
	private String compañia;
	private String nombre;
	private String telefono;
	private String correo;

	// asociacion 1:N desde la tabla usuarios a la tabla usuariosgrupos
	@OneToMany(mappedBy = "primaryKey.tecnicos", cascade = CascadeType.ALL)
	private Set<Asistencia> asistencia = new HashSet<Asistencia>();

	public Tecnicos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tecnicos(String compañia, String nombre, String telefono, String correo) {
		super();
		this.compañia = compañia;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdtecnicos() {
		return idtecnicos;
	}

	public void setIdtecnicos(int idtecnicos) {
		this.idtecnicos = idtecnicos;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<Asistencia> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Set<Asistencia> asistencia) {
		this.asistencia = asistencia;
	}

}
