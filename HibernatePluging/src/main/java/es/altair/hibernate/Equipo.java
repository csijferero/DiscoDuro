package es.altair.hibernate;
// Generated 21-nov-2017 10:35:53 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "equipo", catalog = "hibernate2")
public class Equipo implements java.io.Serializable {

	private Integer idEquipo;
	private String nombre;
	private String ciudad;
	private int numSocios;
	private Set<Jugador> jugadors = new HashSet<Jugador>(0);

	public Equipo() {
	}

	public Equipo(String nombre, String ciudad, int numSocios) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.numSocios = numSocios;
	}

	public Equipo(String nombre, String ciudad, int numSocios, Set<Jugador> jugadors) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.numSocios = numSocios;
		this.jugadors = jugadors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEquipo", unique = true, nullable = false)
	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ciudad", nullable = false, length = 45)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "numSocios", nullable = false)
	public int getNumSocios() {
		return this.numSocios;
	}

	public void setNumSocios(int numSocios) {
		this.numSocios = numSocios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(Set<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

}