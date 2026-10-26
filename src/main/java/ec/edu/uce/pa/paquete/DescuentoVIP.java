package ec.edu.uce.pa.paquete;

import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("vip")
public class DescuentoVIP implements CalculadoraDescuento {
    
    private String id;
    
    public DescuentoVIP() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public double calcularDescuento(double monto) {
        System.out.println("Calculando descuento VIP   ID: " + id );
        return monto * 0.15; 
    }

}
