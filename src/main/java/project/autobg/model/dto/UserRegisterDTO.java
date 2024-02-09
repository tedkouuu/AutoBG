package project.autobg.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import project.autobg.model.validation.FieldMatch;
import project.autobg.model.validation.UniqueUserEmail;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match"
)
public class UserRegisterDTO {

    @NotEmpty
    @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters")
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Last name must be between 3 and 20 characters")
    private String lastName;

    @NotEmpty(message = "User email should be provided")
    @Email(message = "User email should be valid")
    @UniqueUserEmail(message = "User email should be unique")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Size must be between 3 and and 20")
    private String password;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Size must be between 3 and and 20")
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}
