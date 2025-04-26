package clases;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Repartidor extends Usuario {
    private int ID = 0;
    private int numCell = 0;
    private List<Pedido> pedidosAsignados = new ArrayList<>();
    private List<Pedido> historialPedidos = new ArrayList<>();

    public Repartidor(String nombre, String pass, String rol, int iD, int numCell) {
        super(nombre, pass, rol);
        this.ID = iD;
        this.numCell = numCell;
    }

    public void registrarse() {
        JOptionPane.showMessageDialog(null, "Repartidor " + getNombre() + " registrado con éxito.");
    }

    public void verPedidosAsignados() {
        if (pedidosAsignados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos asignados.");
        } else {
            StringBuilder sb = new StringBuilder("Pedidos asignados:\n");
            for (Pedido p : pedidosAsignados) {
                sb.append("ID: ").append(p.getIdPedido()).append(", Estado: ").append(p.getEstado()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
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

    public void verEstadoPedido() {
       
        int idPedido = 1; 
        JOptionPane.showMessageDialog(null, "Buscando estado del pedido con ID: " + idPedido);
        for (Pedido pedido : pedidosAsignados) {
            if (pedido.getIdPedido() == idPedido) {
                JOptionPane.showMessageDialog(null, "Estado del pedido " + idPedido + ": " + pedido.getEstado());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
    }

    public void verMapa() {
        JOptionPane.showMessageDialog(null, "Mostrando mapa para el repartidor " + getNombre());
    }

    public void editarPerfil() {
        
        String nuevoNombre = "RepartidorActualizado"; 
        String nuevaPass = "nuevaPass123"; 
        int nuevoNumCell = 555555555; // 
        JOptionPane.showMessageDialog(null, "Actualizando perfil con nombre: " + nuevoNombre + ", contraseña: " + nuevaPass + ", número de celular: " + nuevoNumCell);
        setNombre(nuevoNombre);
        setPass(nuevaPass);
        this.numCell = nuevoNumCell;
        JOptionPane.showMessageDialog(null, "Perfil actualizado para " + nuevoNombre);
    }

    public void verMenu() {
        
        JOptionPane.showMessageDialog(null, "Menú del Repartidor: Este sistema ejecutará acciones predefinidas.");
        JOptionPane.showMessageDialog(null, "1. Ver Pedidos Asignados");
        verPedidosAsignados();
        JOptionPane.showMessageDialog(null, "2. Ver Historial de Pedidos");
        verHistorialPedidos();
        JOptionPane.showMessageDialog(null, "3. Ver Estado de Pedido (ID predefinido)");
        verEstadoPedido();
        JOptionPane.showMessageDialog(null, "4. Ver Mapa");
        verMapa();
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

    public int getNumCell() {
        return numCell;
    }

    public void setNumCell(int numCell) {
        this.numCell = numCell;
    }
}