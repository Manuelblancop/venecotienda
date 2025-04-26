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
            for (Pedido pedido : pedidosAsignados) {
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

    public void verMapa() {
        JOptionPane.showMessageDialog(null, "Mostrando mapa para el repartidor " + getNombre());
    }

    public void editarPerfil() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nuevo nombre:");
        String pass = JOptionPane.showInputDialog("Ingrese su nueva contraseña:");
        String numCellStr = JOptionPane.showInputDialog("Ingrese su nuevo número de celular:");
        if (nombre == null || nombre.trim().isEmpty() || pass == null || pass.trim().isEmpty() || numCellStr == null || numCellStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int numCell = Integer.parseInt(numCellStr);
            if (numCell <= 0) {
                JOptionPane.showMessageDialog(null, "Error: El número de celular debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            setNombre(nombre);
            setPass(pass);
            this.numCell = numCell;
            JOptionPane.showMessageDialog(null, "Perfil actualizado para " + nombre);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El número de celular debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verMenu() {
        String[] opciones = {"Ver Pedidos Asignados", "Ver Historial de Pedidos", "Ver Estado de Pedido", "Ver Mapa", "Editar Perfil", "Cerrar Sesión"};
        int seleccion = JOptionPane.showOptionDialog(null, "Menú del Repartidor", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        switch (seleccion) {
            case 0 -> verPedidosAsignados();
            case 1 -> verHistorialPedidos();
            case 2 -> verEstadoPedido();
            case 3 -> verMapa();
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

    public int getNumCell() {
        return numCell;
    }

    public void setNumCell(int numCell) {
        this.numCell = numCell;
    }
}