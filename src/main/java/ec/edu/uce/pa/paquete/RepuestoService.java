package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RepuestoService {
    @Inject
    MailService mailService;

    @Inject
    VentasService contadorService;

    public boolean procesarVenta(Repuesto repuesto, int cantidad, String clienteCorreo) {
        System.out.println(
                "\nProcesando pedido para: " + repuesto.getDescripcion() + " [" + repuesto.getCategoria() + "]");
        System.out.println("Compatible con: " + repuesto.getModeloCompatible());

        if (repuesto.getStock() < cantidad) {
            System.out.println("Stock insuficiente para " + repuesto.getDescripcion()
                    + ". Disponibles: " + repuesto.getStock() + "  Solicitados: " + cantidad);
            return false;
        }

        repuesto.setStock(repuesto.getStock() - cantidad);
        double totalVenta = repuesto.getPrecio() * cantidad;

        System.out.println("Despacho aprobado.Stock restante: " + repuesto.getStock());

        contadorService.registrarVenta(cantidad, totalVenta);
        mailService.enviarComprobante(clienteCorreo, repuesto.getCodigoParte(), repuesto.getDescripcion(),repuesto.getMarca(), cantidad, totalVenta);

        return true;
    }
}
