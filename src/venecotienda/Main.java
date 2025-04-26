package venecotienda;
import javax.swing.JOptionPane;
import clases.*;
import singleton.Sesion;

public class Main {
    public static void main(String[] args) {
        
        Admin admin = new Admin("Manu", "admin01", "admin", 1);
        Cliente cliente = new Cliente("Liev", "cliente01", "cliente", 2, 123456789, "Calle Sarmiento");
        Repartidor repartidor = new Repartidor("Tomas", "repartidor01", "repartidor", 3, 987654321);

        
        Admin.productos.add(new Producto(1, "Arepa", 1000, "Arepa con quesoisi", 50));

       
        JOptionPane.showMessageDialog(null, "Bienvenido a nuestro restaurante");

       
        String rolSeleccionado = "admin"; 
        JOptionPane.showMessageDialog(null, "Rol seleccionado: " + rolSeleccionado);

        
        Usuario usuarioLogueado = null;
        switch (rolSeleccionado) {
            case "admin":
                usuarioLogueado = admin;
                break;
            case "cliente":
                usuarioLogueado = cliente;
                break;
            case "repartidor":
                usuarioLogueado = repartidor;
                break;
        }

        if (usuarioLogueado != null && usuarioLogueado.iniciarSesion()) {
            Sesion.getInstancia().iniciarSesion(usuarioLogueado);
            while (Sesion.getInstancia().haySesionActiva()) {
                switch (rolSeleccionado) {
                    case "admin":
                        admin.verMenu();
                        break;
                    case "cliente":
                        cliente.verMenu();
                        break;
                    case "repartidor":
                        repartidor.verMenu();
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa nuevamente bro.");
        }
    }
}