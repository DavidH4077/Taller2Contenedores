package ec.edu.uce.pa.paquete;

import jakarta.inject.Singleton;

@Singleton
public class VentasService {
    private int totalTransacciones = 0;
    private int totalPiezasVendidas = 0;
    private double montoTotalRecaudado = 0.0;

    public void registrarVenta(int cantidad, double monto) {
        this.totalTransacciones++;
        this.totalPiezasVendidas += cantidad;
        this.montoTotalRecaudado += monto;
    }

    public void mostrarEstadisticas() {
        System.out.println("\n================ RESUMEN DE VENTAS  ================");
        System.out.println("Transacciones realizadas: " + totalTransacciones);
        System.out.println("Piezas de repuestos despachadas: " + totalPiezasVendidas);
        System.out.println("Total recaudado en caja: $" + montoTotalRecaudado);
    }
}
