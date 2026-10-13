package aman.example.xmlconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//           OrderService orderService = context.getBean(OrderService.class); // isse agar do bean ho gye to code fat jayega
//        orderService.placeOrder();

        // ek tarika ye bhi h
//        OrderService orderService = (OrderService) context.getBean("orderService");
//        orderService.placeOrder();

//        OrderService orderService = context.getBean(  "orderService", OrderService.class); // isliye ye best approach h
          //orderService.placeOrder();

        // to name/id kuch bhi pass kar skte ho
//        PaymentService paymentService = context.getBean(  "paymentServiceBean", PaymentService.class);

//        paymentService.pay();
//        orderService.placeOrder();

        UserService userService = (UserService) context.getBean("userService");
//        userService.getName();
        context.close();
    }

}
