package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("sms")
public class SMSService implements Notificacion {

    @Override
    public void notificar(String mensaje) {
        System.out.println("SMSService -> " + mensaje);
    }
}