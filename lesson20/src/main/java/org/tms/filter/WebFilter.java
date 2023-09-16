package org.tms.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookieKey") && cookie.getValue().equals("cookieValue")) {
                    chain.doFilter(request, response);
                }
                else {
                    throw new RuntimeException("The WebFilter blocked the connection");
                }
            }
        } else {
            throw new RuntimeException("Access closed.");
        }
    }

    @Override
    public void destroy() {
    }
}