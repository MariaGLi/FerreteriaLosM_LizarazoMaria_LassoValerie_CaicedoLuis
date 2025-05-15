package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

    private static final String SECRET_KEY ="1234567893487234263465234752736457235423423423454";

    @Override
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }

    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
        .signWith(getKey(),SignatureAlgorithm.HS256)
        .compact();
    }

    private Key getKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }

    private Claims getAllClaims(String token){
        return Jwts
        .parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    
    @Override
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }
    
    @Override
    public boolean isTokenValid(String token, UserDetails userdetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userdetails.getUsername())&& !isTokenExpired(token));
    }
    
    public Date getExpiration(String token){
        return getClaim(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String Token){
        return getExpiration(Token).before(new Date());
    }
}
