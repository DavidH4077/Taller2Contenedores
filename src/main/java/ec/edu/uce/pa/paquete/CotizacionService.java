package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class CotizacionService {
    private String id=UUID.randomUUID().toString();

    @Inject 
    @Named("vip")
    private CalculadoraDescuento descuentoVIP;

    @Inject 
    Auditoria auditoria;

    public void generarCotizacion(Cotizacion cotizacion) {
        System.out.println("\nEjecutando en CotizacionService  ID: " + id);
        double desc = descuentoVIP.calcularDescuento(cotizacion.getMonto());
        double total = cotizacion.getMonto() - desc;
        auditoria.registrar(" | Cotizacion VIP para " + cotizacion.getCliente() + " | Total estimado: $" + total);
    }
}
