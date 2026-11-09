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

@EnviarSMS
@Interceptor
@Priority(3)
public class EnviarSMSInterceptor {

    @Inject
    @Named("sms")
    private Notificacion smsService;

    @AroundInvoke
    public Object interceptarSMS(InvocationContext context) throws Exception {
        Object resultado = context.proceed();

        Object[] valores = context.getParameters();
        if (valores[0] instanceof Venta) {
            Venta venta = (Venta) valores[0];
            this.smsService.notificar("|INTERCEPTOR|Enviando SMS a " + venta.getCliente() + " por compra de " + venta.getHerramienta());
        } else if (valores[0] instanceof Cotizacion) {
            Cotizacion cot = (Cotizacion) valores[0];
            this.smsService.notificar("|INTERCEPTOR|Enviando SMS a " + cot.getCliente() + " por cotizacion generada");
        }

        return resultado;
    }
}