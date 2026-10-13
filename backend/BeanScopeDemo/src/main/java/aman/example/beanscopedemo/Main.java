package aman.example.beanscopedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
           OrderService o1 = context.getBean(OrderService.class);
//           OrderService o2 = context.getBean(OrderService.class);
           o1.placeOrder();
//        System.out.println(o1 == o2);
    }
}
