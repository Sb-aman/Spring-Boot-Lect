package aman.example.springdemo2;

import aman.example.springdemo2.notification.EmailService;
import aman.example.springdemo2.notification.NotificationService;
import aman.example.springdemo2.notification.smsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemo2Application {

    public static void main(String[] args) {
        NotificationService notification = new smsService();
        orderService order = new orderService(notification);
        order.placedOrder();
    }
}
