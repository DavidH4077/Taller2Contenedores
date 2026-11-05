package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.EnviarMail;
import ec.edu.uce.pa.paquete.interceptors.EnviarSmS;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoService {

    @MedirTiempo
    @Auditoria
    @EnviarSmS
    @EnviarMail
    public String realizar(Pedido pedido, String valor1) {

        try {
            Thread.sleep(1500);

        } catch (Exception e) {
        }

        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto:" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito");

        return "PedidoService se ha ejecutado correctamente";
    }

}
