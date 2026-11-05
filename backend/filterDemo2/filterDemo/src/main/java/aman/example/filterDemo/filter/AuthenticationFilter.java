package aman.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String token = httpRequest.getHeader("token");
        String apiKey = httpRequest.getHeader("x-api-key"); // ye error response ke liye


        if (token == null || !token.equals("1234")) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//             httpResponse.sendError(401); // dono me se kuch bhi use kaa skte ho
            return;
        }

        if (apiKey == null || !apiKey.equals("secret123")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                    "{\n" +

                            "  \"message\": \"invalid or missing api key\"\n"+
                        "}");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
