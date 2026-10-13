package com.example.SpringBootWorkDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

//	 ApplicationContext context =	SpringApplication.run(Main.class, args);
//PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//
//  paymentGateway.print();


        // ApplicationRunner interface se jab run karwa rhe ho tb kuch likhne ki need nhi hoti
//        ApplicationContext context =
                SpringApplication.run(Main.class, args);


/*
//	 paymentGateway.setType("BHIM UPI");
//	 paymentGateway.setRetryCount(9);
		System.out.println(paymentGateway.getType());
		System.out.println(paymentGateway.getRetryCount());
        System.out.println(paymentGateway.isEnabled());
        System.out.println(paymentGateway.getTimeOut());

 */
	}

}
