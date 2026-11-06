package aman.example.filterDemo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/*
    AGAR FILTER INTERFACE KO USE NHI KARNA H TO ISSE USE KARNA
 */


//@Component
public class SpringDemoFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri =  request.getRequestURI();
        return !uri.startsWith("/api/"); // to agar /api/ se start nhi hogi to usko filter mat karna
    }

    @Override
    protected void doFilterInternal // ye method internal shouldNotFilter() method ko implement karta h agar kisi ko filter karna h to wo wha se karega agar condition true hui to
            (HttpServletRequest request,
             HttpServletResponse response,
             FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(request, response);
    }
}
