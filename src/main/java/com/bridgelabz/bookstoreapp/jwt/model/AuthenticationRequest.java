package com.bridgelabz.bookstoreapp.jwt.model;

public class AuthenticationRequest {
    public String email;
    public String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
