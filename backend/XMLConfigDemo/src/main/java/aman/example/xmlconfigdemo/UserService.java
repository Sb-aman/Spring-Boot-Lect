package aman.example.xmlconfigdemo;

import java.util.List;

public class UserService {
//   private String name;
//    private List<String> list;
//    public UserService(List<String>list) {
//  this.list = list;
//    }
//    public void getName(){
//        System.out.println("name is : " + list);
//    }

    public UserService(){
        System.out.println("UserService created");
    }

    public void init(){
        System.out.println("post construct called");
    }
    public void destroy(){
        System.out.println("post destroyed");
    }
}
