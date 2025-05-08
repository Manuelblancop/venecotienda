package clases;
import javax.swing.JOptionPane;

public class Delivery extends Pedido {
    private String[] sucursal = {"Sucursales"};
    private String direccion = "";

    public Delivery(int idPedido, Double total, String direccion) {
        super(idPedido, total);
        this.direccion = direccion;
    }

    public void aceptarPedido() {
        setEstado("Aceptado");
        JOptionPane.showMessageDialog(null, "Pedido " + getIdPedido() + " aceptado.");
    }

    public void rechazarPedido() {
        setEstado("Rechazado");
        JOptionPane.showMessageDialog(null, "Pedido " + getIdPedido() + " rechazado.");
    }

    public void verDetallesPedido() {
        String detalles = "Pedido ID: " + getIdPedido() + ", Total: " + getTotal() + ", Estado: " + getEstado() + ", Dirección: " + direccion;
        JOptionPane.showMessageDialog(null, detalles);
    }

    public void marcarComoEntregado() {
        setEstado("Entregado");
        JOptionPane.showMessageDialog(null, "Pedido " + getIdPedido() + " marcado como entregado.");
    }

    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}