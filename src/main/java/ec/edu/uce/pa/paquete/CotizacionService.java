package ec.edu.uce.pa.paquete;

import java.util.UUID;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.EnviarMail;
import ec.edu.uce.pa.paquete.interceptors.EnviarSMS;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class CotizacionService {
    private String id=UUID.randomUUID().toString();

    @Inject 
    @Named("vip")
    private CalculadoraDescuento descuentoVIP;

    @MedirTiempo 
    @Auditoria 
    @EnviarSMS 
    @EnviarMail 
    public String generarCotizacion(Cotizacion cotizacion,String valor) {
        System.out.println("\nEjecutando en CotizacionService  ID: " + id);
        double desc = descuentoVIP.calcularDescuento(cotizacion.getMonto());
        double total = cotizacion.getMonto() - desc;
        cotizacion.setTotal(total);
        System.out.println(" | Cotizacion VIP para " + cotizacion.getCliente() + " | Total estimado: $" +total );
        return "Cotización generada para " + cotizacion.getCliente();
    }
}
