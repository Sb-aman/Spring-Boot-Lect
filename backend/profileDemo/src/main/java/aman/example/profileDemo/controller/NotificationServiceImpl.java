package aman.example.profileDemo.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImpl implements NotificationService {


    @Override
    public String sendNotification() {
        //  real notification is sent (sms/email)
        return " Here is Notification";
    }
}
