package com.truong.whocall.Model;
import java.util.Objects;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }


    public User() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "{" +
            ", username='" + getUsername() + "'" +
            "}";
    }
   
        
}
