package clases;

public class Repartidor extends Usuario{
	//Extender Usuario
	private int ID = 0;
	private int numCell = 0;
	public Repartidor(String nombre, String pass, String rol, int iD, int numCell) {
		super(nombre, pass, rol);
		ID = iD;
		this.numCell = numCell;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getNumCell() {
		return numCell;
	}
	public void setNumCell(int numCell) {
		this.numCell = numCell;
	}
	
	
	
	/////////////Funciones
	// Registrarse
	// Iniciar Sesion
	// Ver pedidos asignados
	// Ver historial de pedidos
	// Ver estado del pedido
	// Ver mapa
	// Editar perfil 
	// Cerrar sesion
	
}
