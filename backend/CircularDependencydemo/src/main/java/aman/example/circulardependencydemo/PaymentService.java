package aman.example.circulardependencydemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
//    @Autowired // field injection
//    private OrderService orderService;  // ye mene circular dependency ke liye create kiya h
    /*
     IMP NOTE : circular dependency ki problem spring ke karan nhi aa rhi
     h ye bad design of code ke karan aa rhi h
     */
//    public PaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }
    public void pay(){
        System.out.println("payment done");
//        orderService.getOrderDetail();
    }
}
