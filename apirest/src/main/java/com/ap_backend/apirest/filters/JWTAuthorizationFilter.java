package com.ap_backend.apirest.filters;

import com.ap_backend.apirest.configs.AuthenticationConfigConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(AuthenticationConfigConstants.HEADER_STRING);

        if (header == null || !header.startsWith(AuthenticationConfigConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader(AuthenticationConfigConstants.HEADER_STRING);

        if (token != null){
            // se hace parse del token
            String user = JWT.require(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(AuthenticationConfigConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null){
                // si se pudo extraer el usuario del token -> ok
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
