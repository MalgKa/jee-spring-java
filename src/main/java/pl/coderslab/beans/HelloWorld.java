package pl.coderslab.beans;

import org.springframework.util.SocketUtils;

import java.time.LocalDateTime;

public class HelloWorld {
    public void hello(){
        System.out.println(LocalDateTime.now());
    }
}
