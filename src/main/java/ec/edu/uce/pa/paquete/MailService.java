package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

//Ambitos y contextos
//@ApplicationScoped //Su ambito Durante toda la plicacion se crea un objeto de la clase y se comparte entre todos los componentes que la utilizan 
//@SessionScoped  //Su ambito es en aplicaciones web durante la sesion del usuario es decir se crea una instancia y se comparte a los usuarios que la utilizan 
//@RequestScoped  //Su ambito Durante toda la plicacion se crea un objeto de la clase y se comparte entre todos los componentes que la utilizan.Su ambito es en aplicaciones web durante el request /peticion http 
//@Singleton //Su ambito es Durante toda la plicacion se crea un objeto de la clase y se comparte con todos los componentes dqeu la utilizan 
@Dependent //Su ambito es durante la inyeccion de dependencias es decir se crea una instancia y se comparte con los componentes que utilicen durante la inyeccion de dependencias 
@Named("mail")
public class MailService implements Notificacion {
    private Integer cantidad = 0;
    private String nombre;

    
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con exito.");
        System.out.println("Fin del envio del correo");

    }

    @Override
    public Integer getCantidad() {
        return this.cantidad;
    }

    @Override
    public void setCantidad(Integer cantidad) {
        this.cantidad=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
