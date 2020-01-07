package com.fokhrul.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Information comming from the user through POST request
 */
public class UserDetailsRequestModel {
    /**
     * Adding some Hibernate validations.
     * We are providing custom error message in case of any error
     */
    @NotNull(message="First name cannot be null")
    @Size(min = 2, message = "Size of first name must be minimum 2 characters")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    @Size(min = 2, message = "Size of last name must be minimum 2 characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be between 8 & 16 inclusive")
    private String password;

    private String userId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
