package ec.edu.uce.pa.paquete;

public class Venta {
    private int numero;
    private String cliente;
    private String correo;
    private String herramienta;
    private String tipoCliente;
    private double monto;
    private double total;

    public Venta() {
    }

    public Venta(int numero, String cliente, String correo, String herramienta, String tipoCliente, double monto,
            double total) {
        this.numero = numero;
        this.cliente = cliente;
        this.correo = correo;
        this.herramienta = herramienta;
        this.tipoCliente = tipoCliente;
        this.monto = monto;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
