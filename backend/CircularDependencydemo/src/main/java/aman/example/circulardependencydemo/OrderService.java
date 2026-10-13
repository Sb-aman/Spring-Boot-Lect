package aman.example.circulardependencydemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private PaymentService paymentService; // field injection
//    public OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
    public void placeOrder() {
        paymentService.pay();
        getOrderDetail();// isse hame dependency resolve karne ki jarurat hi nhi padi. To main
//        goal dependency resolve karna nhi hona chahiye code ki design bdhiya honi chahiye
        System.out.println("order placed");
    }
    public void getOrderDetail(){
        System.out.println("order detail");
    }
}
