package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class VentaService {
    private String id;

    @Inject 
    @Named ("regular")
    private CalculadoraDescuento descuentoRegular;

    @Inject 
    Auditoria auditoria;

    CalculadoraDescuento descuentoVIP;
    
    @Inject 
    public VentaService(@Named ("vip") CalculadoraDescuento descuentoVIP) {
        this.id = UUID.randomUUID().toString();
        this.descuentoVIP = descuentoVIP;
    }

   public void procesarVenta(Venta venta) {

        double descuento = 0;
        String porcentaje = "";
        if (venta.getTipoCliente().equals("REGULAR")) {
            descuento = descuentoRegular.calcularDescuento(venta.getMonto());
            porcentaje = "5%";
        } else if (venta.getTipoCliente().equals("VIP")) {
            descuento = descuentoVIP.calcularDescuento(venta.getMonto());
            porcentaje = "15%";
        }

        double total = venta.getMonto() - descuento;

        auditoria.registrar("|Venta: " + venta.getNumero()  + " " + venta.getHerramienta()  + " | Tipo: " + venta.getTipoCliente()+ " | Monto: $" + venta.getMonto()+ " | Descuento: " + porcentaje + " | Total: $" + total +"|");
    }
}
