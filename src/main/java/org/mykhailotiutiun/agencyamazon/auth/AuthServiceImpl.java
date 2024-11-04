package org.mykhailotiutiun.agencyamazon.auth;

import org.mykhailotiutiun.agencyamazon.exception.NotFoundException;
import org.mykhailotiutiun.agencyamazon.exception.PasswordMatchesException;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenGenerator jwtTokenGenerator;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenGenerator jwtTokenGenerator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.create(user);
        return user;
    }

    @Override
    public String getToken(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new NotFoundException("User not found"));
        if (!passwordEncoder.matches(user.getPassword(), userFromDB.getPassword())){
            throw new PasswordMatchesException("Wrong password");
        }

        return jwtTokenGenerator.generateToken(userFromDB);
    }
}
