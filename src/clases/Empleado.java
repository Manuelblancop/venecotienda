package clases;

public class Empleado extends Usuario {

    public Empleado(String nombre, String contrasenia) {
        super(nombre, contrasenia, "empleado");
    }

    public void actualizarEstadoPedido(Pedido pedido, String nuevoEstado) {
        pedido.setEstado(nuevoEstado);
    }
}
