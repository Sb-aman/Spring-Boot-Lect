package com.example.SpringBootWorkDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

  private PaymentProperties paymentproperties;

  public PaymentGateway(PaymentProperties paymentProperties) {
      this.paymentproperties = paymentProperties;
  }

    public String getType() {
        return paymentproperties.getType();
    }

    public int getRetryCount() {
        return paymentproperties.getRetryCount();
    }

    public int getTimeOut() {
        return paymentproperties.getTimeOut();
    }
    public boolean isEnabled() {
        return paymentproperties.isEnabled() ;
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(isEnabled());
        System.out.println(getTimeOut());
    }









    /*
    @Value("${PaymentGateway.type:RazorPay}") // ye default value h jab application.properties me koi value exist nhi karti hogi tabhi ye value print hogi
    private String type;
    @Value("${PaymentGateway.retry-count}")
    private int retryCount;
     */
    // ****** To jaruri nhi h ki me constructor injection hi karu yha property injection bhi me inject kar skta hu ********

    // to apan constructor set karne se acha @value annotation ka use kar lete h jo
    // constructor ko batata h ki ye value use kanna
 /*
    public PaymentGateway(@Value("${PaymentGateway.type}") String type,           // to yha pe @value(andar jo bhi h )uska means h ki spring environment me is name(PaymentGateway.type) ki property ko dhudho aur uski value ko is parameter me inject karo
                          @Value("${PaymentGateway.retry-count}") int retryCount) {
        this.type = type;
        this.retryCount = retryCount;
    }

  */

    /*
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
        */
}
