package org.example.day6;

//// Subject Interface
//interface Service {
//    void performAction();
//}
//
//// Real Subject
//class RealService implements Service {
//    @Override
//    public void performAction() {
//        System.out.println("RealService: Performing action.");
//    }
//}

// Proxy
class LoggingProxy implements Service {
    private Service realService;

    public LoggingProxy(Service realService) {
        this.realService = realService;
    }

    @Override
    public void performAction() {
        System.out.println("LoggingProxy: Logging before calling real service.");
        realService.performAction();
        System.out.println("LoggingProxy: Logging after calling real service.");
    }
}

// Client
public class StaticProxyDemo {
    public static void main(String[] args) {
        Service realService = new RealService();
        Service proxy = new LoggingProxy(realService);

        proxy.performAction();
    }
}
