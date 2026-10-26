package ec.edu.uce.pa.paquete;

public class Cotizacion {
    private String cliente;
    private double monto;
    
    public Cotizacion(String cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
