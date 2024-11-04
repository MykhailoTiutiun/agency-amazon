package org.mykhailotiutiun.agencyamazon.auth.db;

import org.mykhailotiutiun.agencyamazon.auth.User;
import org.mykhailotiutiun.agencyamazon.auth.UserRepository;
import org.mykhailotiutiun.agencyamazon.exception.AlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserMongoRepositoryAdapter implements UserRepository {

    private final UserMongoRepository userMongoRepository;

    public UserMongoRepositoryAdapter(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserJpa> userJpa = userMongoRepository.getByUsername(username);
        if(userJpa.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(UserJpaMapper.userFromUserJpa(userJpa.get()));
    }

    @Override
    public User create(User user) {
        UserJpa userJpa = UserJpaMapper.userJpaFromUser(user);
        if(userMongoRepository.existsByUsername(userJpa.getUsername())){
            throw new AlreadyExistsException("User already exists");
        }
        userJpa.setId(UUID.randomUUID());
        userMongoRepository.save(userJpa);

        return UserJpaMapper.userFromUserJpa(userJpa);
    }
}
