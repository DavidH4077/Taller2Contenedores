package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Delego el control al contenedor
public class MailService {
    public void enviarComprobante(String destinatario, String codigoParte, String descripcion, String marca,
            int cantidad, double total) {
        System.out.println("Enviando comprobante a: " + destinatario);
        System.out.println("Repuesto: " + descripcion + " (" + marca + ")");
        System.out.println("Codigo de parte: " + codigoParte);
        System.out.println("Cantidad: " + cantidad + " unid. | Total pagado: $" + total);
    }

}
