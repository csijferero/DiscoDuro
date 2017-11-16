package es.mitrabajo.bean;

public class Cancion {
	private int idCancion;
	private int idArtista;
	private String nombreCancion;
	private int duracionCancion;

	public Cancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cancion(int idCancion, int idArtista, String nombreCancion, int duracionCancion) {
		super();
		this.idCancion = idCancion;
		this.idArtista = idArtista;
		this.nombreCancion = nombreCancion;
		this.duracionCancion = duracionCancion;
	}

	public Cancion(int idArtista, String nombreCancion, int duracionCancion) {
		super();
		this.idArtista = idArtista;
		this.nombreCancion = nombreCancion;
		this.duracionCancion = duracionCancion;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public int getDuracionCancion() {
		return duracionCancion;
	}

	public void setDuracionCancion(int duracionCancion) {
		this.duracionCancion = duracionCancion;
	}

	@Override
	public String toString() {
		return "Cancion [Cancion: " + nombreCancion
				+ " | Duracion: " + duracionCancion + "]";
	}

}
