package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
@Priority(InterfacePriority.APPLICATION3)

public class EnviarSmSInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        String resultado = ("|EnviarSMSInterceptor|El metodo envío un SMS");
        return resultado;
    }
}
