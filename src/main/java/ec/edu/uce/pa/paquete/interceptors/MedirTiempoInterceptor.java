package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(InterfacePriority.APPLICATION1)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();
        Object resultado = context.proceed();
        Long fin = System.currentTimeMillis();

        System.out.println("|Interceptor|El metodo demoro: " + (fin - init));
        return resultado;
    }

}
