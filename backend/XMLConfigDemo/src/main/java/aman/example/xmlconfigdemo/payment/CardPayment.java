package aman.example.xmlconfigdemo.payment;

public class CardPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("paying via Card");
    }
}
