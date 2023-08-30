package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.coderslab.beans.*;
import pl.coderslab.config.ApplicationConfig;

/**
 * Hello world!
 */


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        //wyświetli wszystkie beans
        for (String bean : context.getBeanDefinitionNames()) {
            System.out.println(bean);
        }

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.hello();

        NotificationService emailService = context.getBean("emailService", EmailService.class);
        emailService.send();

        Ship ship = context.getBean("blackPearl", Ship.class);
        ship.getCaptain().startSailing();
        ship.getCaptain().conquerTheShip();


        ScopeSingleton singleton1 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton1);
        ScopeSingleton singleton2 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton2);
        System.out.println((singleton1 == singleton2) + ": ten sam obiekt\n");
        ScopePrototype prototype1 = context.getBean(ScopePrototype.class);
        System.out.println(prototype1);
        ScopePrototype prototype2 = context.getBean(ScopePrototype.class);
        System.out.println(prototype2);
        System.out.println((prototype1 == prototype2) + ": dwa różne obiekty");

//  System.out.println((prototype1 == prototype2)? "dwa takie same obiekty" : ": dwa różne obiekty");


        context.close();

    }
}
