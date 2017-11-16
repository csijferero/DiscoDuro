package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "equiposinformaticos")
public class EquiposInformaticos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idequipos;
	private String fabricante;
	private String ubicacion;
	private Date fecha_registro;
	private int precio_compra;

	// asociacion 1:N desde la tabla usuarios a la tabla usuariosgrupos
	@OneToMany(mappedBy = "primaryKey.equiposInformaticos", cascade = CascadeType.ALL)
	private Set<Asistencia> asistencia = new HashSet<Asistencia>();

	public EquiposInformaticos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquiposInformaticos(String fabricante, String ubicacion, Date fecha_registro, int precio_compra) {
		super();
		this.fabricante = fabricante;
		this.ubicacion = ubicacion;
		this.fecha_registro = fecha_registro;
		this.precio_compra = precio_compra;
	}

	public int getIdequipos() {
		return idequipos;
	}

	public void setIdequipos(int idequipos) {
		this.idequipos = idequipos;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Set<Asistencia> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Set<Asistencia> asistencia) {
		this.asistencia = asistencia;
	}

}
