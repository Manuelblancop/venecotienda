package clases;

public class Cliente extends Usuario{
	
	//Extender Usuarios
	private int ID = 0;
	private int numCel = 0;
	private String direccion = "";
	
	public Cliente(String nombre, String pass, String rol, int iD, int numCel, String direccion) {
		super(nombre, pass, rol);
		ID = iD;
		this.numCel = numCel;
		this.direccion = direccion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNumCel() {
		return numCel;
	}

	public void setNumCel(int numCel) {
		this.numCel = numCel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	/////////////Funciones
	// Registrarse
	// Iniciar Sesion
	// Ver productos y comida
	// Hacer pedido
	// Ver estado del pedido
	// Ver historial de pedidos
}
