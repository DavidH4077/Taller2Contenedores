package ec.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.paquete.AuditoriaService;
import ec.edu.uce.pa.paquete.Cotizacion;
import ec.edu.uce.pa.paquete.Venta;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
public class AuditoriaInterceptor {
    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object interceptarAuditoria(InvocationContext context) throws Exception {

        Object resultado = context.proceed();// ejecuta el metodo interceptado
        System.out.println("Retorno: " + resultado);

        String nombreMetodo = context.getMethod().getName();
        System.out.println("Auditoria:Se esta ejecutando el metodo: " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");

        // acceder al metodo
        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();
        if(valores[0] instanceof Venta) {
        Venta venta = (Venta) valores[0];
        String cliente = venta.getCliente();
        double total = venta.getTotal();
        String correo = venta.getCorreo();

        this.auditoriaService.guardarEnlaBase(cliente, total, correo);
        }else if(valores[0] instanceof Cotizacion) {
            Cotizacion cotizacion=(Cotizacion) valores[0];
            String cliente = cotizacion.getCliente();
            double total = cotizacion.getTotal();
            String correo = cotizacion.getCorreo();
            this.auditoriaService.guardarEnlaBase(cliente, total, correo);
        }
        // Todo lo que está arriba se ejecuta antes de ejecutar el metodo interceptado
        System.out.println("Mensaje luego de que se ejecuta el metodo interceptado");
        return resultado;
    }
}
