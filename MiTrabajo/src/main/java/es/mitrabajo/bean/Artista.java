package es.mitrabajo.bean;

public class Artista {
	private int idArtista;
	private int idEstilo;
	private String nombreArtista;
	private String apellidoArtista;
	private int edadArtista;
	private String paisArtista;

	public Artista(int idArtista, int idEstilo, String nombreArtista, String apellidoArtista, int edadArtista,
			String paisArtista) {
		super();
		this.idArtista = idArtista;
		this.idEstilo = idEstilo;
		this.nombreArtista = nombreArtista;
		this.apellidoArtista = apellidoArtista;
		this.edadArtista = edadArtista;
		this.paisArtista = paisArtista;
	}

	public Artista(int idEstilo, String nombreArtista, String apellidoArtista, int edadArtista, String paisArtista) {
		super();
		this.idEstilo = idEstilo;
		this.nombreArtista = nombreArtista;
		this.apellidoArtista = apellidoArtista;
		this.edadArtista = edadArtista;
		this.paisArtista = paisArtista;
	}

	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artista(String paisArtista) {
		super();
		this.paisArtista = paisArtista;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getApellidoArtista() {
		return apellidoArtista;
	}

	public void setApellidoArtista(String apellidoArtista) {
		this.apellidoArtista = apellidoArtista;
	}

	public int getEdadArtista() {
		return edadArtista;
	}

	public void setEdadArtista(int edadArtista) {
		this.edadArtista = edadArtista;
	}

	public String getPaisArtista() {
		return paisArtista;
	}

	public void setPaisArtista(String paisArtista) {
		this.paisArtista = paisArtista;
	}

	@Override
	public String toString() {
		return "Artista [Nombre: " + nombreArtista
				+ " | Apellido: " + apellidoArtista + " | Edad: " + edadArtista + " | Pais: "
				+ paisArtista + "]";
	}

}
