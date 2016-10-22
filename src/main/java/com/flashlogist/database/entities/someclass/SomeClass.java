package com.flashlogist.database.entities.someclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Lex on 20.10.2016.
 */

@Entity
@Table(name = "TEST_SOME_CLASS", uniqueConstraints = {
        @UniqueConstraint(columnNames = "one"),
        @UniqueConstraint(columnNames = "two")
})
@Getter(AccessLevel.PUBLIC) //default value
@Setter(AccessLevel.PUBLIC) //default value
public class SomeClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotEmpty(message = "One cannot be empty")
    @NotNull(message = "One cannot be null")
    @Pattern(regexp = "[A-Za-z0-9_]+", message = "Use only ASCII letters, digits and _ simbol")
    @Size(min = 4, max = 24, message = "One cannot be less than 4 letters and longer than 24 lettets")
    @Column(name = "one", unique = true, nullable = false)
    private String one;

    @NotEmpty(message = "Two cannot be empty")
    @NotNull(message = "Two cannot be null")
    @Pattern(regexp = "[A-Za-z0-9_]+", message = "Use only ASCII letters, digits and _ simbol")
    @Size(min = 4, max = 24, message = "Two cannot be less than 4 letters and longer than 24 lettets")
    @Column(name = "two", unique = true, nullable = false)
    private String two;
}
