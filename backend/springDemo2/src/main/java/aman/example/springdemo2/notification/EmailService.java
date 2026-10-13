package aman.example.springdemo2.notification;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("email is sent");
    }
}
