package aman.example.springdemo2.notification;

public class smsService implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("send sms notification");
    }
}
