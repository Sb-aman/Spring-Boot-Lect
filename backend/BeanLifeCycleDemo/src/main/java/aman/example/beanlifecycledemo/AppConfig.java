package aman.example.beanlifecycledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {


//@Bean(initMethod = "start" ,destroyMethod = "stop") // to ye method CartService me banana padega
//    public CartService  getCartBean(){ // ye init method 2nd method of initialization aur destruction callback ke liye
//        return new CartService();
//    }
}
