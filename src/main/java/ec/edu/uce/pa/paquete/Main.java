package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.CompraService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {
   @Inject 
    private PedidoService  pedidoService;

    @Inject 
    private CompraService compraService;
    public static void main(String[] args) {
        Quarkus.run(Main.class,args);

    }
    @Override 
    public int run(String... args){
                System.out.println("Iniciando aplicacion de quarkus");

        Pedido pedido = new Pedido("David Perez", "Laptop", 1250, "juan@gmail.com");// crear manualmente el objeto de la
        pedido.setTelefono("015212154512112");                                                                           // clase Pedido
        pedidoService.realizar(pedido);


        Compra compra=new Compra("David Lopez", "Celular", 1500, "davidl@gmail.com", "098202302003");
        compraService.realizar(compra);
        
        return 0;
    } 
}
