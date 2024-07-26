package org.example.day7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ConstructorInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Service service = context.getBean(Service.class);
        service.performService();
    }
}
@Component
class Service {
    private final Repository repository;

    // Constructor Injection
    public Service(Repository repository) {
        this.repository = repository;
    }

    // Business logic
    public void performService() {
        repository.doSomething();
    }
}
@Component
class Repository {
    // Data access logic
    public void doSomething() {
        System.out.println("Doing something in Repository");
    }
}
@Configuration
@ComponentScan(basePackages = "org.example.day7")
class AppConfig {
}
