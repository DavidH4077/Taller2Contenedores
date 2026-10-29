package ec.edu.uce.pa.paquete;

public class Cotizacion {
    private String cliente;
    private double monto;
    private String correo;
    private double total;
    
    public Cotizacion() {
    }

    public Cotizacion(String cliente, double monto, String correo) {
        this.cliente = cliente;
        this.monto = monto;
        this.correo = correo;
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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }    
}
