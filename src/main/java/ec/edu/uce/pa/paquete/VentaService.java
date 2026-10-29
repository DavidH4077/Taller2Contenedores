package ec.edu.uce.pa.paquete;

import java.util.UUID;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class VentaService {
    private String id;

    @Inject 
    @Named ("regular")
    private CalculadoraDescuento descuentoRegular;

    
    CalculadoraDescuento descuentoVIP;
    
    @Inject 
    public VentaService(@Named ("vip") CalculadoraDescuento descuentoVIP) {
        this.id = UUID.randomUUID().toString();
        this.descuentoVIP = descuentoVIP;
    }

    @Auditoria 
   public String procesarVenta(Venta venta,String valor) {

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
        venta.setTotal(total);

        System.out.println("|Venta: " + venta.getNumero()  +" | Nombre: "+ venta.getCliente() + " | Correo: " + venta.getCorreo() + " | Herramienta: " + venta.getHerramienta()  + " | Tipo: " + venta.getTipoCliente()+ " | Monto: $" + venta.getMonto()+ " | Descuento: " + porcentaje + " | Total: $" + total +"|");
        return "Venta procesada correctamente";
    }
}
