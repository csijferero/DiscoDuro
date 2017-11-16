package es.altair.hibernate.bean;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
	private int idGrupo;
	private String nombre;

	// asociacion 1:N desde la tabla grupos a la tabla usuariosgrupos
	@OneToMany(mappedBy = "grupo")
	private Set<UsuarioGrupo> usuariosGrupos = new HashSet<UsuarioGrupo>();

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioGrupo> getUsuariosGrupos() {
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(Set<UsuarioGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

}
