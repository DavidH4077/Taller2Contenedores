package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("mail")
public class MailService implements Notificacion {

    @Override
    public void notificar(String mensaje) {
        System.out.println("MailService -> " + mensaje);
    }
}