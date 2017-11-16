package es.altair.hibernate.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AsistenciaId implements Serializable {

	@ManyToOne(cascade = CascadeType.ALL)
	private Tecnicos tecnicos;

	@ManyToOne(cascade = CascadeType.ALL)
	private EquiposInformaticos equiposInformaticos;

	public AsistenciaId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AsistenciaId(Tecnicos tecnicos, EquiposInformaticos equiposInformaticos) {
		super();
		this.tecnicos = tecnicos;
		this.equiposInformaticos = equiposInformaticos;
	}

	public Tecnicos getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(Tecnicos tecnicos) {
		this.tecnicos = tecnicos;
	}

	public EquiposInformaticos getEquiposInformaticos() {
		return equiposInformaticos;
	}

	public void setEquiposInformaticos(EquiposInformaticos equiposInformaticos) {
		this.equiposInformaticos = equiposInformaticos;
	}

}
