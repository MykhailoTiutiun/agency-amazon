package org.mykhailotiutiun.agencyamazon.auth.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document("user")
public class UserJpa {

    @Id
    private UUID id;
    @TextIndexed
    private String username;
    private String password;

    public UserJpa() {}

    public UserJpa(UserJpaBuilder builder) {
        id = builder.id;
        username = builder.username;
        password = builder.password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserJpaBuilder builder(){
        return new UserJpaBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJpa userJpa = (UserJpa) o;
        return Objects.equals(id, userJpa.id) && Objects.equals(username, userJpa.username) && Objects.equals(password, userJpa.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    public static class UserJpaBuilder {

        private UUID id;
        private String username;
        private String password;

        private UserJpaBuilder(){}

        public UserJpaBuilder id(UUID id){
            this.id = id;
            return this;
        }

        public UserJpaBuilder username(String username){
            this.username = username;
            return this;
        }

        public UserJpaBuilder password(String password){
            this.password = password;
            return this;
        }

        public UserJpa build(){
            return new UserJpa(this);
        }
    }
}
