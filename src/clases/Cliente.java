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
        String totalStr = JOptionPane.showInputDialog("Ingrese el total del pedido:");
        if (totalStr == null || totalStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: El total no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double total = Double.parseDouble(totalStr);
            if (total <= 0) {
                JOptionPane.showMessageDialog(null, "Error: El total debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idPedido = Admin.pedidos.size() + 1; // Generar un ID simple
            Pedido pedido = new Pedido(idPedido, total);
            Admin.pedidos.add(pedido);
            historialPedidos.add(pedido);
            JOptionPane.showMessageDialog(null, "Pedido realizado con ID: " + idPedido);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El total debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verEstadoPedido() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del pedido:");
        if (idStr == null || idStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: El ID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int idPedido = Integer.parseInt(idStr);
            if (idPedido <= 0) {
                JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (Pedido pedido : historialPedidos) {
                if (pedido.getIdPedido() == idPedido) {
                    JOptionPane.showMessageDialog(null, "Estado del pedido " + idPedido + ": " + pedido.getEstado());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        String[] opciones = {"Ver Productos", "Hacer Pedido", "Ver Estado de Pedido", "Ver Historial de Pedidos", "Cerrar Sesión"};
        int seleccion = JOptionPane.showOptionDialog(null, "Menú del Cliente", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        switch (seleccion) {
            case 0 -> verProductos();
            case 1 -> hacerPedido();
            case 2 -> verEstadoPedido();
            case 3 -> verHistorialPedidos();
            case 4 -> cerrarSesion();
        }
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