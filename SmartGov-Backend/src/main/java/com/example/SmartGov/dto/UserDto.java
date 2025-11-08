package com.example.SmartGov.dto;

import com.example.SmartGov.enums.District;
import com.example.SmartGov.enums.Gender;
import com.example.SmartGov.enums.ROLES;
import com.example.SmartGov.enums.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
public class UserDto {

    private Long userId;

    @NotBlank(message = "First Name Cannot be blank")
    private String firstName;

    @NotBlank(message = "Last Name Cannot be Blank")
    private String lastName;

    @NotNull(message = "dateOfBirth Cannot be null")
    @Past(message = "dateOfBirth must be in past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Aadhar Number  cannot be blank")
    @Size(min =12 , max = 12, message = "Aadhar Number must be exactly 12 in digit ")
    @Pattern(regexp = "^[0-9]{12}$" , message = "Aadhar Number must contain only digit ")
    private String aadharNumber;

    @NotBlank(message = "Email Id cannot be blank ")
    @Email(message = "Invalid Email Id")
    private String email;

    @NotBlank(message = "Mobile  Nummber cannot be blank ")
    @Size(min = 10, max = 10, message = "Mobile Number must be in 10 digit ")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number must be valid")
    private String mobileNumber;

    @NotNull(message = "State must be selected")
    private State state;

    @NotNull(message = "District must be selected")
    private District district;

    @NotNull(message = "Gender must be selected")
    private Gender gender;

    @NotNull(message = "Roles must be selected")
    private ROLES role;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDate createdAt;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "Username can only contain letters, numbers, and underscores")
    private String username;

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ROLES getRole() {
        return role;
    }

    public void setRole(ROLES role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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
}
