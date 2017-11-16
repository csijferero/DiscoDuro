package es.altair.hibernate.bean;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "asistencia")
@AssociationOverrides({
		@AssociationOverride(name = "primaryKey.tecnicos", joinColumns = @JoinColumn(name = "idTecnico")),
		@AssociationOverride(name = "primaryKey.equiposInformaticos", joinColumns = @JoinColumn(name = "idEquipo")) })

public class Asistencia implements Serializable {

	@EmbeddedId
	private AsistenciaId primaryKey = new AsistenciaId();
	private Date fecha_hora;
	private String motivo;

	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asistencia(AsistenciaId primaryKey, Date fecha_hora, String motivo) {
		super();
		this.primaryKey = primaryKey;
		this.fecha_hora = fecha_hora;
		this.motivo = motivo;
	}

	public AsistenciaId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(AsistenciaId primaryKey) {
		this.primaryKey = primaryKey;
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

	@Transient
	public Tecnicos getTecnicos() {
		return primaryKey.getTecnicos();
	}

	@Transient
	public EquiposInformaticos getEquiposInformaticos() {
		return primaryKey.getEquiposInformaticos();
	}

	public void setTecnicos(Tecnicos tecnicos) {
		getPrimaryKey().setTecnicos(tecnicos);
	}

	public void setEquiposInformaticos(EquiposInformaticos equiposInformaticos) {
		getPrimaryKey().setEquiposInformaticos(equiposInformaticos);
	}

}
