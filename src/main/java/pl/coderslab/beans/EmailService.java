package pl.coderslab.beans;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{
    @Override
    public void send() {
        System.out.println("Sending message...");
    }
}
