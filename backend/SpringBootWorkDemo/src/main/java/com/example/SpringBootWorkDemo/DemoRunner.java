package com.example.SpringBootWorkDemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner
        /*ApplicationRunner*/ {
    private PaymentGateway paymentGateway;
    public DemoRunner(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // CommandLineRunner bhi same kam karta h ApplicationRunner jaise
    @Override
    public void run(String... args) throws Exception { // ****** varags argument ******
        paymentGateway.print();
    }
//    @Override
    /*
    // to basically ye args kuch dena chahte to ho de skte ho
    aur isko run karne ke liye kuch likhne ki need nhi hoti automatic ho jata h
         */
//    public void run(ApplicationArguments args) throws Exception {
//        paymentGateway.print();
//    }

}
