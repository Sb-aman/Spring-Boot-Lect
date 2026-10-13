package aman.example.springdemo2;

import aman.example.springdemo2.notification.NotificationService;

public class orderService {
    NotificationService notification ;
    public orderService(NotificationService notification) {
        this.notification = notification;
    }
    public void placedOrder(){
        System.out.println("placed order");
        notification.sendNotification();
    }
}
