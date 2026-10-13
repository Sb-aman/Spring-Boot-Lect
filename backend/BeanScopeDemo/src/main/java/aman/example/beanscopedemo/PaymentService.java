package aman.example.beanscopedemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {
  private OrderService  orderService;
  public PaymentService( OrderService orderService) {
    this.orderService = orderService;
  }
    public  void pay(){
        System.out.println("pay");
        orderService.orderDetails();
    }
}
