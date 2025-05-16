package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import singleton.Conexion;

public class Cliente extends Usuario {
    private int ID = 0;
    private int numCel = 0;
    private String direccion = "";
    private List<Pedido> historialPedidos = new ArrayList<>();

    public Cliente(String nombre, String pass, String rol, int iD, int numCel, String direccion) {
        super(nombre, pass, rol);
        ID = iD;
        this.numCel = numCel;
        this.direccion = direccion;
        cargarHistorialPedidos();
    }

    private void cargarHistorialPedidos() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM pedido WHERE fk_cliente = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                historialPedidos.add(new Pedido()); // Simplificado
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar historial.");
        }
    }

    public void registrarse() {
        JOptionPane.showMessageDialog(null, "Cliente " + getNombre() + " registrado.");
    }

    public void verProductos() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM producto";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder("Productos:\n");
            while (rs.next()) {
                sb.append(rs.getString("nombre")).append(" - ").append(rs.getDouble("precio")).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos.");
        }
    }

    public void hacerPedido() {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "INSERT INTO pedido (productos, fk_met_pago, fk_cliente) VALUES (?, 1, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "Producto de prueba");
            stmt.setInt(2, ID);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido realizado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer pedido.");
        }
    }

    public void verEstadoPedido() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del pedido:"));
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

    public void verHistorialPedidos() {
        if (historialPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos en el historial.");
        } else {
            StringBuilder sb = new StringBuilder("Historial:\n");
            for (Pedido p : historialPedidos) {
                sb.append("ID: ").append(p.getIdPedido()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void verMenu() {
        JOptionPane.showMessageDialog(null, "Menú del Cliente: Ejecutando acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Productos");
        verProductos();
        JOptionPane.showMessageDialog(null, "2. Hacer Pedido");
        hacerPedido();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedido");
        verEstadoPedido();
        JOptionPane.showMessageDialog(null, "4. Ver Historial de Pedidos");
        verHistorialPedidos();
        JOptionPane.showMessageDialog(null, "5. Cerrar Sesión");
        cerrarSesion();
    }

    public int getID() { return ID; }
    public void setID(int iD) { ID = iD; }
    public int getNumCel() { return numCel; }
    public void setNumCel(int numCel) { this.numCel = numCel; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}