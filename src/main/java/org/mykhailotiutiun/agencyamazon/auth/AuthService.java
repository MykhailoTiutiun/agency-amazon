package org.mykhailotiutiun.agencyamazon.auth;

public interface AuthService {
    User register(User user);

    String getToken(User user);
}
