package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {
  @Inject
    VentaService ventaService;

    @Inject
    CotizacionService cotizacionService;

    public static void main(String... args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("========== FERRETERIA  ==========");

        Venta v1 = new Venta(1, "Aurelio Valderrama", "Aurelio@gmail.com", "Taladro Inalambrico", "REGULAR", 150, 0);
        Venta v2 = new Venta(2, "Alexis Lopez", "Alexis@gmail.com", "Soldadora Inverter", "VIP", 900, 0);
        Venta v3 = new Venta(3, "Daniela Jurado", "Daniela@gmail.com", "Compresor de Aire", "REGULAR", 300, 0);
        Venta v4 = new Venta(4, "Sebastian Urrutia", "Sebastian@gmail.com", "Generador Electrico", "VIP", 800, 0);

        ventaService.procesarVenta(v1,"");
        ventaService.procesarVenta(v2,"");
        ventaService.procesarVenta(v3,"");
        ventaService.procesarVenta(v4,"");

       
        Cotizacion c1 = new Cotizacion("Constructora Andina", 1000.00,"Andina@gmail.com");
        cotizacionService.generarCotizacion(c1,"");

        return 0;
    }
}
