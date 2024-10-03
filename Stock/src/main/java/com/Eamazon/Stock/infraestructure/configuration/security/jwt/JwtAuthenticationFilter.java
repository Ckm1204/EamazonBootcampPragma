package com.Eamazon.Stock.infraestructure.configuration.security.jwt;

import com.Eamazon.Stock.infraestructure.configuration.security.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");


        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try{

            String jwt = authHeader.split(" ")[1];

            UserDetails user = userDetailsService.loadUserByUsername(jwt);



            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, jwt, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);


        }
        catch (Exception e){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,  "Invalid token");
            return;
        }

        filterChain.doFilter(request, response);

    }
}
