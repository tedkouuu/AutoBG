package project.autobg.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Size must be between 3 and and 20")
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
