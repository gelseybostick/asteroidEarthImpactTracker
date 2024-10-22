package org.example.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class User {
    // We need to create a password hash.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    // We'll need a username, password and login token.
    private int id;
    private String username;
    private String role;
    @JsonIgnore
    private String securityQuestion;
    @JsonIgnore
    private String hashedPassword;
    public User(int id, String username, String role, String securityQuestion, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.securityQuestion = securityQuestion;
        this.hashedPassword = password;
    }

}
