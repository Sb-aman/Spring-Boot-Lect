package aman.example.beanlifecycledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
//      ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /* basically ye upar wali parent interface class h ye close() method ko call nhi karti
            isliye niche Wali method banai gyi h jo child interface class h jo close() ko call karti h
         */
        ConfigurableApplicationContext context2 =  new AnnotationConfigApplicationContext(AppConfig.class);

//      OrderService order = context.getBean(OrderService.class);
//      order.placeOrder();

//        UserService i = context.getBean(UserService.class);
//        i.setBeanName("aman"); // ye bhale hi compiler me aman show kara de lekin spring container me original hi ho

//       CartService cartService = context2.getBean(CartService.class);
//       cartService.getName(1);

//        context.close();
//       context2.close();
    }

}
