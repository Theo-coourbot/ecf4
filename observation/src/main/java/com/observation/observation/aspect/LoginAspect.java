package com.observation.observation.aspect;


import com.observation.observation.tool.RestClient;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LoginAspect {
    @Before("execution(* com.observation.observation.controller.ObservationController.*(..))")
    public void testToken() {
        RestClient<String, String> restClient = new RestClient<>();
        HttpServletRequest servletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = servletRequest.getHeader("Authorization");
        if(!restClient.testToken(token, String.class)) {
            throw new RuntimeException();
        }
    }
}
