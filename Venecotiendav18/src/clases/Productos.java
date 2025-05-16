package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import singleton.Conexion;

public class Productos {
    private int ID = 0;
    private String nombre = "";
    private String descripcion = "";
    private Double precio = 0.0;
    private String[] categoria = {"Comida"};

    public Productos(int iD, String nombre, String descripcion, Double precio, String[] categoria) {
        ID = iD;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public static Productos buscarPorId(int id) {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM producto WHERE id_producto = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Productos(rs.getInt("id_producto"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getDouble("precio"), new String[]{""});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar producto.");
        }
        return null;
    }

    public static void filtrarPorCategoria(String categoria) {
        try {
            Connection conexion = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM producto WHERE fk_categoria = (SELECT id_categoria FROM categoria WHERE nombre = ?)";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder("Productos en " + categoria + ":\n");
            while (rs.next()) {
                sb.append(rs.getString("nombre")).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar.");
        }
    }

    // Getters y Setters
    public int getID() { return ID; }
    public void setID(int iD) { ID = iD; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripccion() { return descripcion; }
    public void setDescripccion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public String[] getCategoria() { return categoria; }
    public void setCategoria(String[] categoria) { this.categoria = categoria; }
}
