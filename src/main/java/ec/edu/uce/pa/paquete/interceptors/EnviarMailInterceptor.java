package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Cotizacion;
import ec.edu.uce.pa.paquete.Notificacion;
import ec.edu.uce.pa.paquete.Venta;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@EnviarMail
@Interceptor
@Priority(4)
public class EnviarMailInterceptor {

    @Inject
    @Named("mail")
    private Notificacion mailService;

    @AroundInvoke
    public Object interceptarMail(InvocationContext context) throws Exception {
        Object resultado = context.proceed();

        Object[] valores = context.getParameters();
        if (valores[0] instanceof Venta) {
            Venta venta = (Venta) valores[0];
            this.mailService.notificar("|INTERCEPTOR|Enviando correo a " + venta.getCorreo() + " por total: $" + venta.getMonto());
        } else if (valores[0] instanceof Cotizacion) {
            Cotizacion cot = (Cotizacion) valores[0];
            this.mailService.notificar("|INTERCEPTOR|Enviando correo a " + cot.getCorreo() + " por cotizacion: $" + cot.getMonto());
        }


        return resultado;
    }
}