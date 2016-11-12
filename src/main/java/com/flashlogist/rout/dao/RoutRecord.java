package com.flashlogist.rout.dao;

import com.flashlogist.utils.dao.LocalDateConverter;
import com.flashlogist.user.dao.User;
import com.flashlogist.vehicle.dao.Vehicle;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

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

    @ElementCollection
    @CollectionTable(
            name="record_hubs",
            joinColumns = @JoinColumn(name = "record_id")
    )
    private Collection<TransportHub> transportHubs;
}