package clases;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cliente extends Usuario {
    private int ID = 0;
    private int numCel = 0;
    private String direccion = "";
    private List<Pedido> historialPedidos = new ArrayList<>();

    public Cliente(String nombre, String pass, String rol, int iD, int numCel, String direccion) {
        super(nombre, pass, rol);
        this.ID = iD;
        this.numCel = numCel;
        this.direccion = direccion;
    }

    public void registrarse() {
        JOptionPane.showMessageDialog(null, "Cliente " + getNombre() + " registrado con éxito.");
    }

    public List<Producto> verProductos() {
        List<Producto> productos = Admin.productos;
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
        } else {
            StringBuilder sb = new StringBuilder("Productos disponibles:\n");
            for (Producto p : productos) {
                sb.append(p.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        return productos;
    }

    public void hacerPedido() {
        
        double total = 50.0; 
        JOptionPane.showMessageDialog(null, "Haciendo un pedido con total: " + total);
        int idPedido = Admin.pedidos.size() + 1; 
        Pedido pedido = new Pedido(idPedido, total);
        Admin.pedidos.add(pedido);
        historialPedidos.add(pedido);
        JOptionPane.showMessageDialog(null, "Pedido realizado con ID: " + idPedido);
    }

    public void verEstadoPedido() {
       
        int idPedido = 1; // Valor predefinido
        JOptionPane.showMessageDialog(null, "Buscando estado del pedido con ID: " + idPedido);
        for (Pedido pedido : historialPedidos) {
            if (pedido.getIdPedido() == idPedido) {
                JOptionPane.showMessageDialog(null, "Estado del pedido " + idPedido + ": " + pedido.getEstado());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
    }

    public void verHistorialPedidos() {
        if (historialPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos en el historial.");
        } else {
            StringBuilder sb = new StringBuilder("Historial de pedidos:\n");
            for (Pedido p : historialPedidos) {
                sb.append("ID: ").append(p.getIdPedido()).append(", Estado: ").append(p.getEstado()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void verMenu() {
        
        JOptionPane.showMessageDialog(null, "Menú del Cliente: Este sistema ejecutará acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Productos");
        verProductos();
        JOptionPane.showMessageDialog(null, "2. Hacer Pedido (total predefinido)");
        hacerPedido();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedido (ID predefinido)");
        verEstadoPedido();
        JOptionPane.showMessageDialog(null, "4. Ver Historial de Pedidos");
        verHistorialPedidos();
        JOptionPane.showMessageDialog(null, "5. Cerrar Sesión");
        cerrarSesion();
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getNumCel() {
        return numCel;
    }

    public void setNumCel(int numCel) {
        this.numCel = numCel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}