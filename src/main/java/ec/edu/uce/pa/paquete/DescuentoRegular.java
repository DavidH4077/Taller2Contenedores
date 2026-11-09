package ec.edu.uce.pa.paquete;

import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {
    private String id;

    public DescuentoRegular() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public double calcularDescuento(double monto) {
        System.out.println("Calculando descuento regular   ID: " + id );
        return monto * 0.05;  
    }

}
