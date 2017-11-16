package es.mitrabajo.bean;

public class Estilo {
	private int idEstilo;
	private String nombreEstilo;

	public Estilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estilo(int idEstilo, String nombreEstilo) {
		super();
		this.idEstilo = idEstilo;
		this.nombreEstilo = nombreEstilo;
	}

	public Estilo(String nombreEstilo) {
		super();
		this.nombreEstilo = nombreEstilo;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}

	public String getNombreEstilo() {
		return nombreEstilo;
	}

	public void setNombreEstilo(String nombreEstilo) {
		this.nombreEstilo = nombreEstilo;
	}

	@Override
	public String toString() {
		return "Estilo ["+ nombreEstilo + "]";
	}

}
