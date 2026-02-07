package com.example.SmartGov.entity;

import com.example.SmartGov.enums.District;
import com.example.SmartGov.enums.Gender;
import com.example.SmartGov.enums.ROLES;
import com.example.SmartGov.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "Citizens", uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "aadharNumber")
}
)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth;

    private Gender gender;

    @Column(nullable = false , length = 12,unique = true)
    private String aadharNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false , length = 10, unique = true)
    private String mobileNumber;

    private State States;

    private District district;

    @Enumerated(EnumType.STRING)
    private ROLES role;

    @Column(nullable = false)
    @CreatedDate
    private LocalDate createdAt;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        if (this.role == null) {
            this.role = ROLES.CITIZENS;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getDateOfBirth(), user.getDateOfBirth()) && getGender() == user.getGender() && Objects.equals(getAadharNumber(), user.getAadharNumber()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getMobileNumber(), user.getMobileNumber()) && getStates() == user.getStates() && getDistrict() == user.getDistrict() && getRole() == user.getRole() && Objects.equals(getCreatedAt(), user.getCreatedAt()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getDateOfBirth(), getGender(), getAadharNumber(), getEmail(), getMobileNumber(), getStates(), getDistrict(), getRole(), getCreatedAt(), getUsername(), getPassword());
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public State getStates() {
        return States;
    }

    public void setStates(State states) {
        States = states;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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
