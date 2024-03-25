package com.exploremore.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "phone_no", nullable = false, unique = true, length = 10)
    private String phoneNo;

    @Column(name = "role", nullable = false, length = 10)
    private String role;

    public enum UserRole {
        USER,
        ADMIN,
        MANAGER
    }
    public void setRole(String role) {
        if (!isValidRole(role)) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
        this.role = role;
    }

    private boolean isValidRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equals(role)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
