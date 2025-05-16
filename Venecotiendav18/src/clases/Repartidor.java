package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import singleton.Conexion;

public class Repartidor extends Usuario {
    private int ID = 0;
    private int numCell = 0;
    private List<Pedido> pedidosAsignados = new ArrayList<>();
    private List<Pedido> historialPedidos = new ArrayList<>();

    public Repartidor(String nombre, String pass, String rol, int iD, int numCell) {
        super(nombre, pass, rol);
        ID = iD;
        this.numCell = numCell;
        cargarPedidosAsignados();
    }

    private void cargarPedidosAsignados() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM pedido"; // Necesitarías unir con delivery
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pedidosAsignados.add(new Pedido()); // Simplificado
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos.");
        }
    }

    public void registrarse() {
        JOptionPane.showMessageDialog(null, "Repartidor " + getNombre() + " registrado.");
    }

    public void verPedidosAsignados() {
        if (pedidosAsignados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos asignados.");
        } else {
            StringBuilder sb = new StringBuilder("Pedidos:\n");
            for (Pedido p : pedidosAsignados) {
                sb.append("ID: ").append(p.getIdPedido()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void verHistorialPedidos() {
        if (historialPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay historial.");
        } else {
            StringBuilder sb = new StringBuilder("Historial:\n");
            for (Pedido p : historialPedidos) {
                sb.append("ID: ").append(p.getIdPedido()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void verEstadoPedido() {
        int idPedido = 1; // Valor predefinido
        JOptionPane.showMessageDialog(null, "Buscando estado del pedido con ID: " + idPedido);
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT estado FROM pedido WHERE id_pedido = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Estado: " + rs.getString("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar pedido.");
        }
    }

    public void verMapa() {
        JOptionPane.showMessageDialog(null, "Mapa mostrado para " + getNombre());
    }

    public void editarPerfil() {
        String nuevoNombre = "RepartidorActualizado";
        String nuevaPass = "nuevaPass123";
        int nuevoNumCell = 555555555;
        JOptionPane.showMessageDialog(null, "Actualizando perfil con nombre: " + nuevoNombre + ", contraseña: " + nuevaPass + ", número de celular: " + nuevoNumCell);
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
            numCell = nuevoNumCell;
            JOptionPane.showMessageDialog(null, "Perfil actualizado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar perfil.");
        }
    }

    public void verMenu() {
        JOptionPane.showMessageDialog(null, "Menú del Repartidor: Ejecutando acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Pedidos Asignados");
        verPedidosAsignados();
        JOptionPane.showMessageDialog(null, "2. Ver Historial de Pedidos");
        verHistorialPedidos();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedido");
        verEstadoPedido();
        JOptionPane.showMessageDialog(null, "4. Ver Mapa");
        verMapa();
        JOptionPane.showMessageDialog(null, "5. Editar Perfil");
        editarPerfil();
        JOptionPane.showMessageDialog(null, "6. Cerrar Sesión");
        cerrarSesion();
    }

    public int getID() { return ID; }
    public void setID(int iD) { ID = iD; }
    public int getNumCell() { return numCell; }
    public void setNumCell(int numCell) { this.numCell = numCell; }
}