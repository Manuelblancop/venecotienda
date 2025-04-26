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
     
        int idPedido = 1; 
        JOptionPane.showMessageDialog(null, "Buscando estado del pedido con ID: " + idPedido);
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                JOptionPane.showMessageDialog(null, "Estado del pedido " + idPedido + ": " + pedido.getEstado());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
    }

    public void eliminarProducto() {
     
        int idProducto = 1; 
        JOptionPane.showMessageDialog(null, "Eliminando producto con ID: " + idProducto);
        productos.removeIf(producto -> producto.getIdProducto() == idProducto);
        JOptionPane.showMessageDialog(null, "Producto con ID " + idProducto + " eliminado.");
    }

    public void editarPerfil() {
       
        String nuevoNombre = "AdminActualizado"; 
        String nuevaPass = "nuevaPass123"; 
        JOptionPane.showMessageDialog(null, "Actualizando perfil con nombre: " + nuevoNombre + " y contraseña: " + nuevaPass);
        setNombre(nuevoNombre);
        setPass(nuevaPass);
        JOptionPane.showMessageDialog(null, "Perfil actualizado para " + nuevoNombre);
    }

    public void verMenu() {
       
        JOptionPane.showMessageDialog(null, "Menú del Administrador: Este sistema ejecutará acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Productos");
        verProductos();
        JOptionPane.showMessageDialog(null, "2. Ver Pedidos");
        verPedidosAsignados();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedido (ID predefinido)");
        verEstadoPedido();
        JOptionPane.showMessageDialog(null, "4. Eliminar Producto (ID predefinido)");
        eliminarProducto();
        JOptionPane.showMessageDialog(null, "5. Editar Perfil (valores predefinidos)");
        editarPerfil();
        JOptionPane.showMessageDialog(null, "6. Cerrar Sesión");
        cerrarSesion();
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