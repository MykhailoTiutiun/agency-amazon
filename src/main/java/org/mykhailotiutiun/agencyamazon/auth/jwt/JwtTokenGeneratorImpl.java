package org.mykhailotiutiun.agencyamazon.auth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.mykhailotiutiun.agencyamazon.auth.JwtTokenGenerator;
import org.mykhailotiutiun.agencyamazon.auth.User;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenGeneratorImpl implements JwtTokenGenerator {

    private final SecretKey secret;

    public JwtTokenGeneratorImpl(String secret) {
        this.secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        return Jwts.builder().claims(claims).subject(String.valueOf(user.getId())).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(secret, Jwts.SIG.HS256).compact();
    }
}
