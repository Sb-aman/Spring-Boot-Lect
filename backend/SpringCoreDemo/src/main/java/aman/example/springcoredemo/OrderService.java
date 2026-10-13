package aman.example.springcoredemo;

import aman.example.springcoredemo.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
  // 3rd method of injection field injection
//  @Autowired
  private PaymentService paymentService;

  //  1st method of injection

//  @Autowired // optional h kyunki ek constructor h multiple honge to imp h lagana
  public OrderService(@Qualifier("upiPayment") PaymentService  paymentService) {
    this.paymentService = paymentService;
  }


  // 2nd  method h injection ki Setter injection
/*
  @Autowired
  public void setPaymentService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }
   */

  public void placeOrder() {
    paymentService.pay();
      System.out.println("Order Placed");
  }
}
