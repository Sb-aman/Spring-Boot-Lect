package aman.example.xmlconfigdemo.payment;

public class UPIPayment implements PaymentService{
    @Override
    public void pay() {
        System.out.println("paying via UPI");
    }
}
