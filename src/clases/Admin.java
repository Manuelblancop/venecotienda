package clases;

public class Admin extends Usuario{
	private int ID = 0;

	public Admin(String nombre, String pass, String rol, int iD) {
		super(nombre, pass, rol);
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	/////////////Funciones
	// Iniciar sesión
	// ver pedidos asignados 
	// Ver productos y comidas
	// Ver menu
	// Ver estado de los pedidos
	// Ver eliminar productos 
	// Ver editar perfiles
	
}
