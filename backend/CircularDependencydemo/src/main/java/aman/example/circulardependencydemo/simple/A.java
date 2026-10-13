package aman.example.circulardependencydemo.simple;

public class A {

    private B b;
    public A() {
        System.out.println("A constructor");
      this.b = new B();
    }
}
