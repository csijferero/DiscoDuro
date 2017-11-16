package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAsistencia;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEquipo")
	private EquiposInformaticos equiposInformaticos;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTecnico")
	private Tecnicos tecnicos;

	@Temporal(TemporalType.DATE)
	private Date fecha_hora;

	private String motivo;

	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asistencia(EquiposInformaticos equiposInformaticos, Tecnicos tecnicos, Date fecha_hora, String motivo) {
		super();
		this.equiposInformaticos = equiposInformaticos;
		this.tecnicos = tecnicos;
		this.fecha_hora = fecha_hora;
		this.motivo = motivo;
	}

	public int getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public EquiposInformaticos getEquiposInformaticos() {
		return equiposInformaticos;
	}

	public void setEquiposInformaticos(EquiposInformaticos equiposInformaticos) {
		this.equiposInformaticos = equiposInformaticos;
	}

	public Tecnicos getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(Tecnicos tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
