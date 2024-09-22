package com.truong.whocall.Model;

public class EncryptedUser {
    private String token;


    public EncryptedUser() {
    }

    public EncryptedUser(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public EncryptedUser token(String token) {
        setToken(token);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " token='" + getToken() + "'" +
            "}";
    }
    
    
}
