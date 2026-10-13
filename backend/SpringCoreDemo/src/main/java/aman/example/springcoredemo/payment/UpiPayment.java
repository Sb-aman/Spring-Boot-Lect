package aman.example.springcoredemo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // dono me mat lagana ya to isme ya CardPayment me warana error aayega
@Qualifier
public class UpiPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("pay via UPI");
    }
}
