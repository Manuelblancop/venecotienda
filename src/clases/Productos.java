package clases;

public class Productos {
	private int ID = 0;
	private String nombre = "";
	private String Descripccion = "";
	private Double precio = 0.0;
	private String[] categoria = {"Agregar categorías"};
	
	public Productos(int iD, String nombre, String descripccion, Double precio, String[] categoria) {
		super();
		ID = iD;
		this.nombre = nombre;
		Descripccion = descripccion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripccion() {
		return Descripccion;
	}

	public void setDescripccion(String descripccion) {
		Descripccion = descripccion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String[] getCategoria() {
		return categoria;
	}

	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}
	
	
}
