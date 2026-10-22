package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.CDI;

@ApplicationScoped 
public class PedidoService {
    
    private MailService diferente;
    public void realizar(Pedido pedido) {
        MailService mailService=CDI.current().select(MailService.class).get();


        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto:" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito");

        String asunto = "Confirmacion pedido";
        String cuerpo = "Estimado" + pedido.getCliente() + " su pedido de " +
                pedido.getProducto() + " por un  total de $" + pedido.getTotal()
                + "ha sido realizado con exito.";

        mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }

}
