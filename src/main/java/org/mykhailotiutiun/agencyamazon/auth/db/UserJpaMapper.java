package org.mykhailotiutiun.agencyamazon.auth.db;

import org.mykhailotiutiun.agencyamazon.auth.User;

public class UserJpaMapper {

    public static UserJpa userJpaFromUser(User user){
        return UserJpa.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static User userFromUserJpa(UserJpa userJpa){
        return User.builder()
                .id(userJpa.getId())
                .username(userJpa.getUsername())
                .password(userJpa.getPassword())
                .build();
    }
}
