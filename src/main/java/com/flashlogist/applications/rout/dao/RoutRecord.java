package com.flashlogist.applications.rout.dao;

import com.flashlogist.global.utils.dao.LocalDateConverter;
import com.flashlogist.applications.admin.usermanager.user.dao.User;
import com.flashlogist.vehicle.dao.Vehicle;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "GLOBAL_ROUT_RECORD", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
})
public class RoutRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "starting_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate startingDate;

    @Column(name = "ending_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endingDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @ManyToOne
    private User driver;

    //TODO: to be implemented
//    @OneToMany
//    private Collection<TransportHub> transportHubs;
}
