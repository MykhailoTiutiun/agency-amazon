package org.mykhailotiutiun.agencyamazon.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenValidatorImpl implements JwtTokenValidator{

    private final SecretKey secret;

    public JwtTokenValidatorImpl(String secret) {
        this.secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(secret)
                .build().parseSignedClaims(token).getPayload();
    }

    @Override
    public Boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (SignatureException e){
            return false;
        }
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
}
