package org.mykhailotiutiun.agencyamazon.auth.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserMongoRepository extends MongoRepository<UserJpa, UUID> {

    Optional<UserJpa> getByUsername(String username);
    Boolean existsByUsername(String username);

}
