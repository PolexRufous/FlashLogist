package com.flashlogist.database.entities.vehicle;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "GLOBAL_VEHICLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "regnumber")
})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message="Name cannot be empty")
    @NotNull(message="Name cannot be null")
    @Pattern(regexp="[A-Za-z0-9_]+", message="Use only ASCII letters, digits and _ simbol")
    @Size(min = 6, max = 24, message="Name cannot be less than {min} letters and longer than {max} symbols")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotEmpty(message="Registration number cannot be empty")
    @NotNull(message="Registration number cannot be null")
    @Size(min = 4, max = 24, message="Registration number cannot be less than {min} letters and longer than {max} symbols")
    @Column(name = "regnumber", unique = true, nullable = false)
    private String regnumber;

    @NotNull(message="Type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private VehicleType type;

    @Past(message="Manufactoring date cannot be future")
    @Column(name = "manufacturingdate")
    private Date manufacturingDate;


    @Min(value = 0, message = "Max cargo weight must be positive")
    @Column(name = "maxcargoweight")
    private int maxcargoweight;
}
