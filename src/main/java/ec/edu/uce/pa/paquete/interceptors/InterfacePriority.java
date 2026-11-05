package ec.edu.uce.pa.paquete.interceptors;

import jakarta.interceptor.Interceptor;

public interface InterfacePriority {

    public int APPLICATION1 = Interceptor.Priority.APPLICATION + 1;
    public int APPLICATION2 = Interceptor.Priority.APPLICATION + 2;
    public int APPLICATION3 = Interceptor.Priority.APPLICATION + 3;
    public int APPLICATION4 = Interceptor.Priority.APPLICATION + 4;
}
