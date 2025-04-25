package clases;
import java.util.LinkedList;

public class Pedido {
    private LinkedList<Productos> listaProductos;
    private String metodoDePago;
    private double montoPagar;

    public Pedido() {
        listaProductos = new LinkedList<>();
        montoPagar = 0.0;
    }

    public LinkedList<Productos> getListaProductos() {
        return listaProductos;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }
    
    
    public void agregarProducto(Productos producto) {
    	//Funcion basica para agregar producto y calcular precios
        listaProductos.add(producto);
        montoPagar += producto.getPrecio();
    }

    public void personalizarPedido(String instrucciones) {
        // Acá podrías guardar instrucciones específicas para el pedido
    	// Recibiendo un String con las instrucciones
      
    }

    public void generarRecomendaciones() {
        // Simulación de recomendación de productos
    	// Esto será basado en un algoritmo que tome la cantidad de pedidos que se pidan, (en caso de usar base de datos).
    }

    public void pagarPedido(String metodoDePago) {
    	//Funcion para pagar
        this.metodoDePago = metodoDePago;
    }
       
}

