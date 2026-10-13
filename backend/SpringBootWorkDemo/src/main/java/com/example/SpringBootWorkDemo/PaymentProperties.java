package com.example.SpringBootWorkDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-property") // ye data application.property se legi
public class PaymentProperties {
    private String type;
    private int retryCount;
    public boolean enabled;
    private int timeOut;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }


}
