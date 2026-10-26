package ec.edu.uce.pa.paquete;

public class Venta {
    private int numero;
    private String herramienta;
    private String tipoCliente;
    private double monto;


    public Venta(int numero, String herramienta, String tipoCliente, double monto) {
        this.numero = numero;
        this.herramienta = herramienta;
        this.tipoCliente = tipoCliente;
        this.monto = monto;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getHerramienta() {
        return herramienta;
    }


    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }


    public String getTipoCliente() {
        return tipoCliente;
    }


    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
