package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
@Priority(InterfacePriority.APPLICATION4)
public class EnviarMailInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        String resultado = ("|EnviarMailInterceptor|El metodo envío un Mail");
        return resultado;
    }
}
