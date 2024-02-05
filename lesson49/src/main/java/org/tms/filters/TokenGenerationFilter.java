package org.tms.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tms.service.TokenService;

import java.io.IOException;

@Service
public class TokenGenerationFilter extends OncePerRequestFilter {

    @Autowired
    private InMemoryUserDetailsManager manager;
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username != null) && (!username.isBlank())) {

            UserDetails userDetails = manager.loadUserByUsername(username);

            if (userDetails.getPassword().equals(password)) {
                String token = tokenService.createToken(userDetails);

                response.setHeader("jwt", token);
            }
        }

        filterChain.doFilter(request, response);
    }
}