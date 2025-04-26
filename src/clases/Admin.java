package clases;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Admin extends Usuario {
    private int ID = 0;
    private int numero;
    private String direccion;
    public static List<Producto> productos = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();

    public Admin(String nombre, String pass, String rol, int iD) {
        super(nombre, pass, rol);
        ID = iD;
    }

    public List<Producto> verProductos() {
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

    public List<Pedido> verPedidosAsignados() {
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos disponibles.");
        } else {
            StringBuilder sb = new StringBuilder("Pedidos:\n");
            for (Pedido p : pedidos) {
                sb.append("ID: ").append(p.getIdPedido()).append(", Estado: ").append(p.getEstado()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        return pedidos;
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
            for (Pedido pedido : pedidos) {
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

    public void eliminarProducto() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:");
        if (idStr == null || idStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: El ID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int idProducto = Integer.parseInt(idStr);
            if (idProducto <= 0) {
                JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            productos.removeIf(producto -> producto.getIdProducto() == idProducto);
            JOptionPane.showMessageDialog(null, "Producto con ID " + idProducto + " eliminado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarPerfil() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nuevo nombre:");
        String pass = JOptionPane.showInputDialog("Ingrese su nueva contraseña:");
        if (nombre == null || nombre.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        setNombre(nombre);
        setPass(pass);
        JOptionPane.showMessageDialog(null, "Perfil actualizado para " + nombre);
    }

    public void verMenu() {
        String[] opciones = {"Ver Productos", "Ver Pedidos", "Ver Estado de Pedido", "Eliminar Producto", "Editar Perfil", "Cerrar Sesión"};
        int seleccion = JOptionPane.showOptionDialog(null, "Menú del Administrador", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        switch (seleccion) {
            case 0 -> verProductos();
            case 1 -> verPedidosAsignados();
            case 2 -> verEstadoPedido();
            case 3 -> eliminarProducto();
            case 4 -> editarPerfil();
            case 5 -> cerrarSesion();
        }
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}