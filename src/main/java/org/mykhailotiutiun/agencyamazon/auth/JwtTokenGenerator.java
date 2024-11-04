package org.mykhailotiutiun.agencyamazon.auth;

public interface JwtTokenGenerator {
    String generateToken(User user);
}
