package com.flashlogist.database.entities.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "GLOBAL_USER_ROLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "name"),
})
public class UserRole {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "[A-Za-z]+", message = "Use only ASCII letters")
    @Size(min = 1, max = 24, message = "Name cannot be less than {min} letter and longer than {max} lettets")
    private String name;
}