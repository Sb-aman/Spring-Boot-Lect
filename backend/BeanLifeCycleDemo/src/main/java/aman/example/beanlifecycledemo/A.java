package aman.example.beanlifecycledemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class A {
    B b;
    public A(B b) {
        this.b = b;
    }
    @PostConstruct  // yha ye circular dependency ki problem ko solve kar skta h
    public void setB() {
        b.setA(this);
    }
}
