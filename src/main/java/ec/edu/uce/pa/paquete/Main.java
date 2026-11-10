package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private CompraService compraService;

    @Inject
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando aplicacion de quarkus");

        Compra compra = new Compra("David Herrera", "Celular", 800, "davidherrera@gmail.com", "0925114122");
        compraService.realizar(compra, this.notificacionExtensionMail);

        Compra compra1 = new Compra("Joaquin Perez", "Celular", 800, "joaquinperez@gmail.com", "092599522");
        compraService.realizar(compra1, this.notificacionExtensionSMS);

        Compra compra2 = new Compra("Alan Andrade", "Celular", 800, "alanandrade@gmail.com", "09554244122");
        compraService.realizar(compra2, this.notificacionExtensionWhatsApp);
        return 0;
    }
}
