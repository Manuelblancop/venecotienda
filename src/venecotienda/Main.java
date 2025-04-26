package venecotienda;
import javax.swing.JOptionPane;
import clases.*;
import singleton.Sesion;

public class Main {
    public static void main(String[] args) {
       
        Admin admin = new Admin("Manu", "admin01", "admin", 1);
        Cliente cliente = new Cliente("liev", "cliente01", "cliente", 2, 123456789, "Calle sarmiento");
        Repartidor repartidor = new Repartidor("tomas", "repartidor01", "repartidor", 3, 987654321);

        
        Admin.productos.add(new Producto(1, "Pizza", 10.99, "Pizza de pepperoni", 50));

       
        String[] roles = {"admin", "cliente", "repartidor"};
        String rolSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione su rol:", "Inicio de Sesión", JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

        if (rolSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Aplicación cerrada.");
            return;
        }

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
            JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Cerrando aplicación.");
        }
    }
}