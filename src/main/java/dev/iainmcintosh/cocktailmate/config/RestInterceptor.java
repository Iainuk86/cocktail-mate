package dev.iainmcintosh.cocktailmate.config;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String theMethod = request.getMethod();

        if (HttpMethod.GET.matches(theMethod)) {
            return true;
        }
        else {
            response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
            return false;
        }
    }
}
