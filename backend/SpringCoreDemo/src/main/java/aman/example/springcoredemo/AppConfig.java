package aman.example.springcoredemo;

import aman.example.springcoredemo.payment.CardPayment;
import aman.example.springcoredemo.payment.PaymentService;
import aman.example.springcoredemo.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("aman.example.springcoredemo")
/* agar pkg name nhi dete to ab bhi error nhi aayega by default tumahra
   appconfig jis pkg me hoga wo us pure pkg ko scan karega
 */
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("aman",17);
    }
    @Bean
//    @Primary
    @Qualifier
    public UpiPayment  createPayment() {
        return new UpiPayment();
    }
    @Bean
    @Qualifier
    public CardPayment createCardPayment() {
        return new CardPayment();
    }
    @Bean
    public PaymentService paymentService() {
        return new UpiPayment();
    }
    @Bean
    public OrderService orderService(@Qualifier("createCardPayment") PaymentService paymentService) {
        // iske qualifier me jo method ka name h wahi rakhna
        return new OrderService(paymentService);
    }
}
