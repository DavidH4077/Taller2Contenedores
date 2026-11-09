package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor 
@Priority (1)
public class MedirTiempoInterceptor {

    @AroundInvoke 
    public Object medirTiempoMetodo(InvocationContext context) throws Exception {
       long inicio = System.currentTimeMillis();

        Object resultado = context.proceed();

        long fin = System.currentTimeMillis();
        System.out.println("|INTERCEPTOR|Tiempo de ejecucion del metodo " + context.getMethod().getName() + ": " + (fin - inicio) + " ms");

        return resultado;
    }
}
