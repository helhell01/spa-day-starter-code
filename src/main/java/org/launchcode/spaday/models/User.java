package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {
    @NotBlank(message="Please enter a username")
    @Size(min = 5, max = 15)
    private String username;
    @Email
    private String email;
    @NotBlank(message = "Please enter a password")
    @Size(min = 6, message = "Password must be more than 5 characters long")
    private String password;
    @NotNull(message ="passwords must match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if((!isNull(this.password) && !isNull(this.verifyPassword)) && !this.password.equals(this.verifyPassword)) {
            this.verifyPassword = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}
