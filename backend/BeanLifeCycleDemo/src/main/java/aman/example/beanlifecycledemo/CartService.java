package aman.example.beanlifecycledemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype") // phele singleton tha scope to predestroy call ho rha tha lekin jaise hi prototype hua to
// predestroy call nhi hoga
public class CartService implements BeanNameAware, ApplicationContextAware
        /*implements InitializingBean , DisposableBean*/ {
    Map<Integer, String> mp; // ye basically ek initialization step h jisme me object create hone ke pehle aur
//    dependency injection ke bad ka phase me hu
    // cache wagera ko flush  karne ke liye


    public CartService() {
        mp = new HashMap<>();
        System.out.println("cart service constructor called");
    }
  // ye sab sequence wise call honge isi sequence me
    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is :" + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext is :" + applicationContext);

    }

    // 3rd method of Initialization callback @PostConstruct
    @PostConstruct // spring me iske liye alag se Jakarta dependency download karni padti h
    // lekin spring boot me pehle se hi predefined milte h
    public void start(){
        System.out.println("bean is ready");
        mp.put(1, "raj");
        mp.put(2, "lucky");
        mp.put(3, "astha");
    }

    public void addToCart(){ // phir ye hogi
        System.out.println("added to cart");
    }
    public void getName(int key){
        System.out.println( "name  is: " +  mp.get(key));
    }


    // ye 3rd method h Destruction CallBack ka PreDestroy  ke through
    @PreDestroy // iske liye PostConstruct bana ke rkhna
    public void stop(){
        mp.clear();
        System.out.println("bean is getting destroyed");
    }



    // ye 2nd method h Destruction CallBack ka bean ke destroyMethod ke through
//    public void stop() {
//        mp.clear();
//        System.out.println("bean is getting destroyed");
//    }


    // ye 1st method h Destruction CallBack ka Component me DisposableBean ko implement kar ke
//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("bean is getting destroyed");
//    }


    // ye 1st method h Initialization CallBack ka Component me InitializingBean ko implement karke
//    @Override // pehle ye method call hogi
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("bean is ready");
//        mp.put(1, "raj");
//        mp.put(2, "lucky");
//        mp.put(3, "astha");
//    }


    // ye 2nd method h Initialization CallBack ke Bean me (initMethod)  h
//    public void start(){
//        System.out.println("bean is ready");
//        mp.put(1, "raj");
//        mp.put(2, "lucky");
//        mp.put(3, "astha");
//    }








}
