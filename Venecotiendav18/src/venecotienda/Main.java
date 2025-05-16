package venecotienda;
//Librerias
import javax.swing.JOptionPane;
//Clases
import clases.Usuario;
//Enums
import enums.MenuAdmin;
import enums.MenuCliente;
import enums.MenuEmpleado;
import enums.MenuRepartidor;
import singleton.Conexion;
//Singleton
import singleton.Sesion;
//Base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/venecodb";
//        String user = "root";
//        String password = "";
//        //Conexión con la base de datos
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            //Variables
            String usuarioInput = JOptionPane.showInputDialog("Usuario:");
            String passwordInput = JOptionPane.showInputDialog("Contraseña:");
            // Buscar usuario en la base de datos
            String query = "SELECT * FROM usuario WHERE nombre_usuario = ? AND password = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, usuarioInput);
            stmt.setString(2, passwordInput);
            ResultSet rs = stmt.executeQuery();
            //Singleton y condicionales
            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre_usuario");                
                String rol = verificarRol(conexion, idUsuario);
                //Singleton para el inicio de sesión
                Usuario usuarioLogueado = new Usuario(nombre, usuarioInput, rol);
                Sesion.getInstancia().iniciarSesion(usuarioLogueado);
                JOptionPane.showMessageDialog(null, "Bienvenido, " + nombre);
                // Menús según rol
                switch (rol) {
                	//lievano / lievano1 es el admin
                    case "admin":
                        JOptionPane.showOptionDialog(null, "", "Menú Admin", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuAdmin.values(), MenuAdmin.values()[0]);
                        break;
                    //(agregar)
                    case "cliente":
                        JOptionPane.showOptionDialog(null, "", "Menú Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuCliente.values(), MenuCliente.values()[0]);
                        break;
                    //(agregar)                        
                    case "empleado":
                        JOptionPane.showOptionDialog(null, "", "Menú Empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuEmpleado.values(), MenuEmpleado.values()[0]);
                        break;
                    //(agregar)                        
                    case "repartidor":
                        JOptionPane.showOptionDialog(null, "", "Menú Repartidor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, MenuRepartidor.values(), MenuRepartidor.values()[0]);
                        break;
                    default:
                    	//Atajar el error por rol
                        JOptionPane.showMessageDialog(null, "Rol no identificado.");
                }
            } else {
            	
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
            	//Ciero conexion acá;)))))))))
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //FUNCIONES
    
    //Funcion para validar el rol
    public static String verificarRol(Connection conexion, int idUsuario) throws SQLException {
        if (existeEnTabla(conexion, "admin", "Usuario_id_usuario", idUsuario)) return "admin";
        if (existeEnTabla(conexion, "empleado", "fk_usuario", idUsuario)) return "empleado";
        if (existeEnTabla(conexion, "repartidor", "fk_usuario", idUsuario)) return "repartidor";
        if (existeEnTabla(conexion, "cliente", "fk_usuario", idUsuario)) return "cliente";
        return "desconocido";
    }
    //Funcion para verificar que eixsta en la tabla el usuario ingresado
    public static boolean existeEnTabla(Connection conexion, String tabla, String columna, int idUsuario) throws SQLException {
        String query = "SELECT 1 FROM " + tabla + " WHERE " + columna + " = ?";
        PreparedStatement stmt = conexion.prepareStatement(query);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}
