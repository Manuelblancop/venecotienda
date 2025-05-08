package clases;
import javax.swing.JOptionPane;

public class Pedido {
    private int idPedido;
    private String[] metodo_pay = {"Mercado pago", "Credito", "Debito", "Efectivo"};
    private Double total = 0.0;
    private String estado = "Pendiente";
    private String personalizaciones = "";

    public Pedido(int idPedido, Double total) {
        this.idPedido = idPedido;
        this.total = total;
    }

    public void personalizarPedidos() {
        
        String personalizaciones = "Sin queso extra"; 
        JOptionPane.showMessageDialog(null, "Personalizando pedido con: " + personalizaciones);
        this.personalizaciones = personalizaciones;
        JOptionPane.showMessageDialog(null, "Pedido personalizado: " + personalizaciones);
    }

    public void generarRecomendaciones() {
        JOptionPane.showMessageDialog(null, "Recomendación: Agregar bebida al pedido.");
    }

    public void pagarPedido() {
        
        String metodo = "Efectivo"; 
        JOptionPane.showMessageDialog(null, "Pagando pedido con método: " + metodo);
        for (String m : metodo_pay) {
            if (m.equalsIgnoreCase(metodo)) {
                this.estado = "Pagado";
                JOptionPane.showMessageDialog(null, "Pedido pagado con " + metodo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: Método de pago no válido.");
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}