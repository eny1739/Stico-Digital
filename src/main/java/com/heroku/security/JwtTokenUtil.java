package com.heroku.security;

import com.heroku.service.UserDetailsServiceDBImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenUtil {

    @Value("${SECRET}")
    private String secret;

    @Autowired
    private UserDetailsServiceDBImpl userDetailsServiceDB;

    public String generateToken(UserDetails userDetails){

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(60*60*10000)))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return token;
    }

    public UserDetails parseToken(String token){
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
        String username = claimsJws.getBody().getSubject();
        return userDetailsServiceDB.loadUserByUsername(username);
    }
}
