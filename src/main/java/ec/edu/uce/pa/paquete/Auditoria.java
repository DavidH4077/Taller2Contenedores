package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent 
public class Auditoria {
    private String id;

    public Auditoria() {
        this.id = UUID.randomUUID().toString();
    }

    public void registrar(String detalle) {
        System.out.println("[Auditoria:" + id + " ]" +"-->" + detalle);
    }

}
