package aman.example.xmlconfigdemo;

import aman.example.xmlconfigdemo.payment.PaymentService;

//@Component
public class OrderService {

    private PaymentService paymentService;
    public OrderService(PaymentService paymentService) {
         this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("order placed");
    }
}
