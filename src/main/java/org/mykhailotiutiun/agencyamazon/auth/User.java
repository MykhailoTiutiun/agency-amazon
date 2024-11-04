package org.mykhailotiutiun.agencyamazon.auth;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class User implements Serializable {

    private UUID id;
    private String username;
    private String password;

    public User() {}

    public User(UserBuilder builder) {
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

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    public static class UserBuilder {

        private UUID id;
        private String username;
        private String password;

        public UserBuilder id(UUID id){
            this.id = id;
            return this;
        }

        public UserBuilder username(String username){
            this.username = username;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
