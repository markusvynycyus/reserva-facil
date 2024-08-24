package com.reserva_facil.hotelService.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Room {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String roomNumber;

    @NotBlank
    @Column(nullable = false)
    private int capacity;

    @NotBlank
    @Column(nullable = false)
    private double price;

    @ManyToOne
    private Hotel hotel;
}
