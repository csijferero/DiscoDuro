package bean;

public class ModeloCoche {
	
	private int anyo;
	private int velocidadMaxima;
	private float precio;
	private String nombre;
	private String marca;
	
	public ModeloCoche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloCoche(int anyo, int velocidadMaxima, float precio, String nombre, String marca) {
		super();
		this.anyo = anyo;
		this.velocidadMaxima = velocidadMaxima;
		this.precio = precio;
		this.nombre = nombre;
		this.marca = marca;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "ModeloCoche [anyo=" + anyo + ", velocidadMaxima=" + velocidadMaxima + ", precio=" + precio + ", nombre="
				+ nombre + ", marca=" + marca + "]";
	}
	
	
	
	
	
	
	

}
