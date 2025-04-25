package venecotienda;
//Librerias
import javax.swing.JOptionPane;
//Clases
import clases.Usuario;
import clases.Admin;
//Enums
import enums.MenuAdmin;
import enums.MenuCliente;
import enums.MenuEmpleado;
import enums.MenuRepartidor;
//Singleton
import singleton.Sesion;

public class Main {
    public static void main(String[] args) {

        //log admin (Prueba)
        Usuario admin = new Usuario("Pedro", "admin01","admin");
        Sesion.getInstancia().iniciarSesion(admin);        
        Usuario logueado = Sesion.getInstancia().getUsuarioActual();
        
        if (logueado != null) {
        	JOptionPane.showMessageDialog(null, "Bienvenido, " + logueado.getNombre());
            String rol = logueado.getRol();
	            switch (rol) {
	                case "admin":
	                	JOptionPane.showOptionDialog(null, "", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuAdmin.values(), MenuAdmin.values()[0]);
	                    break;
	                case "cliente":
	                	JOptionPane.showOptionDialog(null, "", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuCliente.values(), MenuCliente.values()[0]);
	                    break;
	                case "empleado":
	                	JOptionPane.showOptionDialog(null, "", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuEmpleado.values(), MenuEmpleado.values()[0]);
	                    break;
	                case "repartidor":
	                	JOptionPane.showOptionDialog(null, "", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuRepartidor.values(), MenuRepartidor.values()[0]);
	                    break;
	                default:
	                    System.out.println("Error-444"); //Usuario no encontrado
	            }
        }
    }
}
