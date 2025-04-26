package clases;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import singleton.Sesion;

public class Usuario {
    private String nombre = "";
    private String contrasenia = "";
    private String rol = "";
    private static LinkedList<Usuario> usuarios = new LinkedList<>();

    public Usuario(String nombre, String contrasenia, String rol) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        usuarios.add(this);
    }

    public boolean iniciarSesion() {
        String nombreInput = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
        String passInput = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");

        
        if (nombreInput == null || nombreInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (passInput == null || passInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La contraseña no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.nombre.equals(nombreInput) && this.contrasenia.equals(passInput)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido, " + nombre);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error: Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void cerrarSesion() {
        Sesion.getInstancia().cerrarSesion();
        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return contrasenia;
    }

    public void setPass(String contrasenia) {
        this.contrasenia = contrasenia;
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