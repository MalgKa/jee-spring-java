package pl.coderslab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.coderslab.beans.*;

import java.time.LocalDateTime;

@ComponentScan(basePackages = "pl.coderslab")
@Configuration
public class ApplicationConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }


    @Bean
    public Captain jackSparrow() {
        return new Captain();
    }

    @Bean
    public Ship blackPearl() {
        return new Ship(jackSparrow());
    }

    @Bean
    public ScopeSingleton scopeSingleton(){
        return new ScopeSingleton();
    }

    @Bean
    @Scope("prototype")
    ScopePrototype scopePrototype(){
        return new ScopePrototype();
    }

/*można zaznaczyć springowi, że ta klasa będzie beanem -> poniżej.
(lub 2 sposób -> w klasie EmailService dopisać nad klasą adnotację @Component a w Klasie np
konfiguracyjnej -> tu ApplicationConfig (można też w klasie Main) nad klasą dopisać: @ComponentScan(basePackages="pl.coderslab"),żeby spring przeszukał komponenty
wtedy nie trzeba dopisywać już tej metody niżej z adnotacją @Bean

 */

//    @Bean
//    public EmailService emailService() {
//        return new EmailService();
//    }

}
