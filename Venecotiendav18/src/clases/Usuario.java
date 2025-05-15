package clases;
import java.util.LinkedList;

public class Usuario {
	
	private String nombre = "";
	private String pass = "";
	private String rol = "";
	private static LinkedList<Usuario> usuarios = new LinkedList<>();
	
	public Usuario(String nombre, String pass, String rol) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public static LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}
	
	
}
