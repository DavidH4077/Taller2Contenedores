package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtension;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped //Al ser logica de negocio
public class CompraService {

    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {

        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + compra.getCliente());
        System.out.println("Producto:" + compra.getProducto());
        System.out.println("Total:" + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Compra realizado con éxito");

        //programar el envio de notificacion
        notificacionExtension.enviar("Su pedido ha sido realizada con éxito", compra.getCliente());

    }
}
