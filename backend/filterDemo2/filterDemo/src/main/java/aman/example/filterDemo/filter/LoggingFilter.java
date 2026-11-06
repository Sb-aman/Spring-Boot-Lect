package aman.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        long startTime = System.currentTimeMillis(); // for API response time calculate

        String requestId = UUID.randomUUID().toString();
        httpResponse.setHeader("X-Request-Id", requestId); /* isko yha karne ka reason h kyunki
        response aane ke bad wo commit ho jata h to usme change nhi ho skta h isliye
         apan pehle hi jab request aati h tab hamare pass HttpServletResponse
         ka object rhta h to usme hi uska object add kar dete h
         */

            // Request log
        System.out.println("Incoming status :" +
                httpRequest.getMethod() +
                 httpRequest.getRequestURI());

        try {
            filterChain.doFilter(servletRequest, servletResponse); // ise try me isliye rkhte h kyunki bina try ke ye exception me bhi na chale
        }
        finally {
            long endTime = System.currentTimeMillis()-startTime;

            // Response log status
            System.out.println("response status: " +
                    httpResponse.getStatus());

            System.out.println("API response time: " + endTime + "ms");
        }

    }
}
