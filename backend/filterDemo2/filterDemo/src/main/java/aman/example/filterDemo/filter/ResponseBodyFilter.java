package aman.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrappedResponse
                =  new ContentCachingResponseWrapper(httpResponse);

        filterChain.doFilter(servletRequest, wrappedResponse);

        byte[] originalByteBody = wrappedResponse.getContentAsByteArray(); // pehle byte nikala

        String originalBody = new String(originalByteBody); // then convert into string

        String modifiedBody =
                """
                        {
                        "originalBody": %s,\s
                        "appName":"Student Management App"
                        }
                       \s""".formatted(originalBody); // is %s ki  value ye originalBody bharega

        wrappedResponse.resetBuffer();

        wrappedResponse.getWriter().write(modifiedBody);
        wrappedResponse.copyBodyToResponse(); // means wrappedResponse ka response copy karna actual response body me
    }
}
