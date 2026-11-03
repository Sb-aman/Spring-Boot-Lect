package aman.example.profileDemo.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev" ,"default" ,"staging"})  // in sabhi environment ke liye chalega
public class DemoNotificationServiceImpl implements NotificationService{

    @Override
    public String sendNotification() {

        // dummy notification is sent( no real notification)
        return "here is dummy notification ";
    }
}
