package aman.example.springcoredemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
//          PaymentService paymentService = new PaymentService();
//    orderService.placeOrder();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);// IoC container start karne ki line h
//    OrderService orderService = new OrderService(paymentService); -> pehle is tarah kar rhe the
        // lekin ab
        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        User user  = context.getBean(User.class);
//        System.out.println(user.getName());
//        System.out.println(user.getAge());

}
}