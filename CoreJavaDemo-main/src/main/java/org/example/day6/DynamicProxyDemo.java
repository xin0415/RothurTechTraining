package org.example.day6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Subject Interface
interface Service {
    void performAction();
}

// Real Subject
class RealService implements Service {
    @Override
    public void performAction() {
        System.out.println("RealService: Performing action.");
    }
}

// Invocation Handler
class LoggingInvocationHandler implements InvocationHandler {
    private Object realSubject;

    public LoggingInvocationHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Before method " + method.getName());
        Object result = method.invoke(realSubject, args);
        System.out.println("Logging: After method " + method.getName());
        return result;
    }
}

// Client
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Service realService = new RealService();

        // Create a dynamic proxy for the Service interface
        Service proxy = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                new Class[]{Service.class},
                new LoggingInvocationHandler(realService)
        );

        // Use the proxy
        proxy.performAction();
    }
}
