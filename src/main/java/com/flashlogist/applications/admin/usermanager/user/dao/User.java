package com.flashlogist.applications.admin.usermanager.user.dao;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "GLOBAL_USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "login")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message="Login cannot be empty")
    @NotNull(message="Login cannot be null")
    @Pattern(regexp="[A-Za-z0-9_]+", message="Use only ASCII letters, digits and _ simbol")
    @Size(min = 4, max = 24, message="Login cannot be less than {min} letters and longer than {max} letters")
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @NotEmpty(message="Password cannot be empty")
    @NotNull(message="Password cannot be null")
    @Pattern(regexp="[A-Za-z0-9_]+", message="Use only ASCII letters, digits and _ simbol")
    @Size(min = 4, max = 24, message="Password cannot be less than {min} letters and longer than {max} lettets")
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "available")
    private boolean available;

    @NotEmpty(message="First name cannot be empty")
    @NotNull(message="First name cannot be null")
    @Pattern(regexp="[A-Za-z]+", message="Use only ASCII letters")
    @Size(min = 1, max = 24, message="First name cannot be less than {min} letter and longer than {max} lettets")
    @Column(name = "firstname")
    private String firstName;

    @NotEmpty(message="Last name cannot be empty")
    @NotNull(message="Last name cannot be null")
    @Pattern(regexp="[A-Za-z]+", message="Use only ASCII letters")
    @Size(min = 1, max = 24, message="Last name cannot be less than {min} letter and longer than {max} lettets")
    @Column(name = "lastname")
    private String lastName;

    @NotEmpty(message="Email cannot be empty")
    @NotNull(message="Email cannot be null")
    @Email(message="Use correct email")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull(message="Role cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;
}
