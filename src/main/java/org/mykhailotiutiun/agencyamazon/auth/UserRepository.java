package org.mykhailotiutiun.agencyamazon.auth;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
    User create(User user);
}
