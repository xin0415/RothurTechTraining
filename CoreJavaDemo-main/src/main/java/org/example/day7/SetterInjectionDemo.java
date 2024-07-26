package org.example.day7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class SetterInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        Service2 service = context.getBean(Service2.class);
        service.performService();
    }
}
@Component
class Service2 {
    private Repository2 repository;

    // Setter Injection
    @Autowired
    public void setRepository(Repository2 repository) {
        this.repository = repository;
    }

    // Business logic
    public void performService() {
        repository.doSomething();
    }
}
@Component
class Repository2 {
    // Data access logic
    public void doSomething() {
        System.out.println("Doing something in Repository setter");
    }
}
@Configuration
@ComponentScan(basePackages = "org.example.day7")
class AppConfig2 {
}