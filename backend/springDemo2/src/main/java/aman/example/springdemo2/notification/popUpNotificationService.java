package aman.example.springdemo2.notification;

public class popUpNotificationService implements  NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("send pop up notification");
    }
}
