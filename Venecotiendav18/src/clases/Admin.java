package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import singleton.Conexion;

public class Admin extends Usuario {
    private int ID = 0;

    public Admin(String nombre, String pass, String rol, int iD) {
        super(nombre, pass, rol);
        ID = iD;
    }

    public void verPedidosAsignados() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT id_pedido, productos, fk_cliente FROM pedido";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder("Pedidos:\n");
            boolean hayPedidos = false;
            while (rs.next()) {
                hayPedidos = true;
                sb.append("ID: ").append(rs.getInt("id_pedido"))
                  .append(", Productos: ").append(rs.getString("productos"))
                  .append(", Cliente ID: ").append(rs.getInt("fk_cliente"))
                  .append("\n");
            }
            if (hayPedidos) {
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No hay pedidos asignados. Por favor, agrega pedidos a la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos: " + e.getMessage());
        }
    }

    public void verProductos() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT id_producto, nombre, descripcion, precio FROM producto";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder("Productos:\n");
            boolean hayProductos = false;
            while (rs.next()) {
                hayProductos = true;
                sb.append("ID: ").append(rs.getInt("id_producto"))
                  .append(", Nombre: ").append(rs.getString("nombre"))
                  .append(", Descripción: ").append(rs.getString("descripcion"))
                  .append(", Precio: $").append(rs.getDouble("precio"))
                  .append("\n");
            }
            if (hayProductos) {
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos disponibles. Por favor, agrega productos a la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e.getMessage());
        }
    }

    public void verEstadoPedidos() {
        int idPedido = 1; // Valor predefinido
        JOptionPane.showMessageDialog(null, "Buscando estado del pedido con ID: " + idPedido);
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT productos FROM pedido WHERE id_pedido = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Pedido ID " + idPedido + ": " + rs.getString("productos"));
            } else {
                JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar pedido: " + e.getMessage());
        }
    }

    public void eliminarProducto() {
        int idProducto = 1; // Valor predefinido
        JOptionPane.showMessageDialog(null, "Eliminando producto con ID: " + idProducto);
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "DELETE FROM producto WHERE id_producto = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idProducto);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
        }
    }

    public void editarPerfil() {
        String nuevoNombre = "AdminActualizado";
        String nuevaPass = "nuevaPass123";
        JOptionPane.showMessageDialog(null, "Actualizando perfil con nombre: " + nuevoNombre + ", contraseña: " + nuevaPass);
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "UPDATE usuario SET nombre_usuario = ?, password = ? WHERE id_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevaPass);
            stmt.setInt(3, getIdUsuario());
            stmt.executeUpdate();
            setNombre(nuevoNombre);
            setPass(nuevaPass);
            JOptionPane.showMessageDialog(null, "Perfil actualizado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar perfil: " + e.getMessage());
        }
    }

    public void verMenu() {
        JOptionPane.showMessageDialog(null, "Menú del Admin: Ejecutando acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Pedidos Asignados");
        verPedidosAsignados();
        JOptionPane.showMessageDialog(null, "2. Ver Productos");
        verProductos();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedidos");
        verEstadoPedidos();
        JOptionPane.showMessageDialog(null, "4. Eliminar Producto");
        eliminarProducto();
        JOptionPane.showMessageDialog(null, "5. Editar Perfil");
        editarPerfil();
        JOptionPane.showMessageDialog(null, "6. Cerrar Sesión");
        cerrarSesion();
    }

    public int getID() { return ID; }
    public void setID(int iD) { ID = iD; }
}