package com.flashlogist.rout.dao;

import javax.persistence.*;

@Entity
@Table(name = "GLOBAL_TRANSPORT_HUB", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
})
public class TransportHub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
