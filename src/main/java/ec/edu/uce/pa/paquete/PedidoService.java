package ec.edu.uce.pa.paquete;

import jakarta.inject.Inject;

//@ApplicationScoped //Delego el control al contenedor ArC
//@RequestScoped  //funciona solo en apps web
//@Singleton 
public class PedidoService {
    
      /*@Inject
     private MailService mailService;
     */
    private MailService mailService;

    
      //Inyeccion de dependencias por constructor
      /*@Inject
     public PedidoService(MailService mailService){
     this.mailService=mailService;
     } 
      */
     
     

    ///Inyeccion de dependencias por setter
    @Inject
    public void setMailService(MailService mailService) {
        System.out.println("Se está inyectando el servicio de correo electronico pedido service");
        this.mailService = mailService;
    }
    
   
    public void realizar(Pedido pedido) {
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

        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }

}
