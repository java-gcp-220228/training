package com.revature.service;

import com.revature.model.User;
import io.javalin.http.UnauthorizedResponse;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWTService {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createJWT(User user) {
        String jwt = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("user_role", user.getUserRole())
                .signWith(key)
                .compact();

        return jwt;
    }

    public void validateJwt(String jwt) {
        try {
            Jws<Claims> token = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);

            System.out.println(token.getBody());
        } catch(JwtException e) {
            throw new UnauthorizedResponse("JWT was invalid");
        }

    }

}
