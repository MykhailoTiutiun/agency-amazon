package org.mykhailotiutiun.agencyamazon.security;

import io.jsonwebtoken.Claims;

public interface JwtTokenValidator {

    Claims extractAllClaims(String token);
    Boolean validateToken(String token);
}
