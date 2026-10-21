package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    RepuestoService repuestoService;

    @Inject
    VentasService ventasService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
    
    @Override
    public int run(String... args) {
        System.out.println("=== INICIO SISTEMA ALMACÉN DE REPUESTOS ===");

        Repuesto bujias = new Repuesto("REP-001", "BKR5E-11", "Bujía de Cobre", "NGK", "Toyota Stout 2200 / Hilux 4Y",
                "Encendido", 4.25, 12);

        Repuesto carburador = new Repuesto("REP-002", "21100-75030", "Carburador 2 Bocas", "Aisan", "Toyota Motor 4Y",
                "Alimentación de Combustible", 135.00, 2);

        repuestoService.procesarVenta(bujias, 4, "taller.mecanica@empresa.com");
        repuestoService.procesarVenta(carburador, 3, "distribuidora@repuestos.ec");
        repuestoService.procesarVenta(carburador, 1, "cliente.particular@gmail.com");
        ventasService.mostrarEstadisticas();

        return 0;
    }

    
}