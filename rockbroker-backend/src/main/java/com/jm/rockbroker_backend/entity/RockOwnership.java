package com.jm.rockbroker_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rock_ownerships")
public class RockOwnership {
    /*
    * This class represents a table of Rock Ownerships, dictating which user owns
    * what rocks as well as the given quantity that they own.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "rock_id", nullable = false)
    private Rock rock;

    @Column(nullable = false)
    private Integer quantity;
}
