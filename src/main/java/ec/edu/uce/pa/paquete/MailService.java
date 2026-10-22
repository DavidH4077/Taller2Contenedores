package ec.edu.uce.pa.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

//@ApplicationScoped //Delego el control al contenedor
//@RequestScoped  //funciona solo en apps web
@Singleton 
@Named ("mail")
public class MailService implements Notificacion {

    
public void enviar(String correo, String asunto, String cuerpo) {

        System.out.println("Enviando correo a: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con éxito");
    }

    @Override 
    public void enviar(String destino,String mensaje){
        System.out.println("Enviando correo a: "+destino);
        System.out.println("Mensaje: "+mensaje);
        System.out.println("Correo enviado con exito.");
        System.out.println("Fin del envio del correo");
        
    }
}
