package aman.example.beanlifecycledemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("usersService") // nick name set kar skte ho ye camel case me hota h
public class UserService implements BeanNameAware, ApplicationContextAware {


    public UserService() {
//        System.out.println("UserService constructor");
    }

    @Override
    // aise method ko (CallBack) method khte h kyunki spring call kar rha h
    public void setBeanName(String name) {
//        System.out.println("bean name is :" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("applicationContext is :" + applicationContext);
    }
}
