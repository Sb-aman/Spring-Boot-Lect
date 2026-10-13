package aman.example.beanscopedemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class OrderService {
   private  PaymentService paymentService;
    public OrderService(@Lazy PaymentService paymentService) {
        // ye circular dependency ki problem to solve ho jayegi lekin hame cicular ko solve nhi karna h hame use hatana h
//        System.out.println("OrderService created");
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("order placed");
    }
    public void orderDetails() {
        System.out.println("order details");
    }
}
