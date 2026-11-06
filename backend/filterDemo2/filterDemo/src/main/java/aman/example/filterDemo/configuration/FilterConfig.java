package aman.example.filterDemo.configuration;

import aman.example.filterDemo.filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> filterRegistrationBean() {
         FilterRegistrationBean<DummyFilter> registrationBean = new FilterRegistrationBean<>();
         registrationBean.setFilter(new DummyFilter());
         registrationBean.addUrlPatterns("/api/* , /admin/*"); // to basically iska matlab h ki kin kin end point ke liye ye dummy filter chalega
         return registrationBean;
    }
}
