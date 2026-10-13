package aman.example.springcoredemo.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier
public class CardPayment implements  PaymentService {
    @Override
    public void pay() {
        System.out.println("pay via Card");
    }
}
