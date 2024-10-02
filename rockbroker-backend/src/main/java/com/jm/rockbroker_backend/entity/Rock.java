package com.jm.rockbroker_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rocks")
public class Rock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will auto-increment the primary key
    private Long id;

    @Column(name = "name", unique = true, nullable = false) // By default, jpa will use the name of the attribute, but we can specify like this
    private String name;

    @Column(name = "ticker", unique = true, nullable = false)
    private String ticker;

    @Column(name = "price", precision = 2, nullable = false)
    private Double price;

}
